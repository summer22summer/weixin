package com.yc.web.controllors;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yc.bean.WeixinUser;
import com.yc.biz.AccessTokenBiz;
import com.yc.biz.WeixinUserBiz;
import com.yc.message.resp.TextMessage;
import com.yc.utils.CheckUtil;
import com.yc.utils.XmlAndMap;
@RestController
public class AccessTokenController {
	
	@Resource(name="accessTokenBizImpl")
	private AccessTokenBiz accessTokenBiz;
	

	@Resource(name="weixinUserBiz")
	private WeixinUserBiz weixinUserBiz;
	

	// 微信服务器认证发送一条get请求
	@RequestMapping(value = "/weixin.action", method = RequestMethod.GET)
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 将微信发过来的参数数据转换成map
		// Map<String,String> map = XmlAndMap.xmlToMap(req);

		String signature = req.getParameter("signature"); // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
		String timestamp = req.getParameter("timestamp"); // 时间戳
		String nonce = req.getParameter("nonce"); // 随机数
		String echostr = req.getParameter("echostr"); // 随机字符串

		// 如果请求来自微信则返回echostr给微信 用来验证成功
		PrintWriter out = resp.getWriter();
		if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
	}
	
	@RequestMapping(value="/weixin.action",method=RequestMethod.POST)
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, org.apache.http.ParseException, ParseException {
		
        //将传过来xml转换为map
        Map<String, String> map = XmlAndMap.xmlToMap(req);
        
        System.out.println( "收到用户发来的信息:"+map );
        
        
        PrintWriter out = resp.getWriter();
        //获取来自请求的信息
        String toUserName = map.get("ToUserName");
        String fromUserName = map.get("FromUserName");
        String msgType = map.get("MsgType");
        String content = map.get("Content");
		
		System.out.println( toUserName +"*******************" );
		

        //用户操作事件为点击菜单
        if("event".equals(msgType)){
        	String message = null;
	        String Event = map.get("Event");
	        //事件为关注
        	if(Event.equals("subscribe")){
        		//关注时添加到数据库
        		WeixinUser weixinUser=new WeixinUser();
        		weixinUser.setOpenId(fromUserName);
				weixinUser=weixinUserBiz.getWechatUser(weixinUser);

				//先查询是否存在该用户
				WeixinUser wu=new WeixinUser();  
				wu=weixinUserBiz.findUser(weixinUser);
				//不存在则插入  存在即更新
				if(wu!=null){
					 weixinUserBiz.updateUser(weixinUser);
				}else{
					weixinUserBiz.addUser(weixinUser);
				}
        	
	            TextMessage text = new TextMessage();
	            text.setToUserName(fromUserName);
	            text.setFromUserName(toUserName); 
	            text.setMsgType("text");     //返回的类型
	            text.setCreateTime(  new Date().getTime() );
	            text.setContent("欢迎来到小咸鱼");	
	            message = XmlAndMap.textMessageToXml(text);
		        out.print(message);
		        out.flush();
		        out.close();
        	}else if(Event.equals("unsubscribe")){
				//取消关注
        		WeixinUser weixinUser=new WeixinUser();
        		weixinUser.setOpenId(fromUserName);

				//先查询是否存在该用户
        		WeixinUser wu=new WeixinUser();
        		wu=weixinUserBiz.findUser(weixinUser);
				//存在即删除
				if(wu!=null){
					 weixinUserBiz.deleteUser( weixinUser);
				}
				
			}else if( Event.equals("CLICK") ){
            	
            	}
			}
        }
	
	
}
