package com.yc.web.controllors;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.yc.bean.WeixinUser;
import com.yc.biz.WeixinUserBiz;

@RestController
public class WeixinUserController {
	
	@Resource(name="weixinUserBizImpl")
	private WeixinUserBiz  weixinUserBiz;
	
	@RequestMapping("showUser.action")
	public void showUserList(HttpServletResponse response,HttpSession session){
		//weixinUserBiz.getAndSaveUser();
		List<WeixinUser> list=weixinUserBiz.findAllUser();
		Gson gson=new Gson();
	
		int count=weixinUserBiz.findUserCount();

		//easyui要求的格式
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("total", count);
		map.put("rows", list);
		String jsonstr=gson.toJson(map);
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter out=null;
		
		try {
			out=response.getWriter();
		} catch (IOException e) {
			System.out.println("响应内容失败");
			e.printStackTrace();
		}
		session.setAttribute("userinfo",jsonstr);
		out.println(jsonstr);
		out.flush();
		out.close();
		

	}
}
