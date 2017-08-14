package com.yc.biz.impl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.ParseException;
import org.springframework.stereotype.Service;

import com.yc.bean.AccessToken;
import com.yc.bean.WeixinUser;
import com.yc.biz.AccessTokenBiz;
import com.yc.biz.WeixinUserBiz;
import com.yc.dao.BaseDao;
import com.yc.utils.WeixinUtil;


import net.sf.json.JSONObject;



@Service
public class WeixinUserBizImpl implements WeixinUserBiz{
	
		@Resource(name="baseDao")
		private BaseDao baseDao;
		
		@Resource(name="accessTokenBizImpl")
		private AccessTokenBiz accessTokenBiz;
		
		@SuppressWarnings("unchecked")
		public void refreshUser(){
			JSONObject jsonObject=new JSONObject();
			WeixinUser wu=new WeixinUser();
			AccessToken at=new AccessToken();
			at= (AccessToken) accessTokenBiz.serachAccessToken();
			try {
				jsonObject=WeixinUtil.doGetStr(WeixinUtil.USERList_URL.replace("ACCESSTOEKN",at.getAccessToken().replace("NEXT_OPENID", "")));
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("连接失败!");
			}
			wu.setTotal(jsonObject.getInt("total"));
			wu.setCount(jsonObject.getInt("count"));
			String openidList=jsonObject.getJSONObject("data").getString("openid");
			String [] openCls=null;
			if(openidList.length()<28){
				wu.setOpenId(openidList);
				wu=this.getWechatUser(wu);
				System.out.println(wu);
			}else{
				openCls = openidList.substring(2,openidList.length()-2).split("\",\"");
				for(int i=0;i<openCls.length;i++){
					wu.setOpenId(openCls[i]);
					wu=this.getWechatUser(wu);
					//判断是否关注了公众号  关注了 即可进行数据库操作
					if(wu.getSubscribe()==1){
						//先查询是否存在该用户
						WeixinUser wu2=new WeixinUser();
						wu2=(WeixinUser) baseDao.findOne(wu, "findUserByOpenid"); //ud.findUserByOpenid(wu);
						//不存在则插入  存在即更新
						if(wu2!=null){
							baseDao.update(wu, "updateUser");//ud.updateUser(wu);
						}else{
							baseDao.save(wu, "addUser");//ud.addUser(wu);
						}
					}
				}
			}
		}

		@Override
		public WeixinUser getWechatUser(WeixinUser weixinuser) {
			JSONObject jsonObject=new JSONObject();
			WeixinUser wu=new WeixinUser();
			AccessToken at=new AccessToken();
			at=(AccessToken) accessTokenBiz.serachAccessToken();
			try {
				jsonObject=WeixinUtil.doGetStr(WeixinUtil.USER_URL.replace("ACCESS_TOKEN", at.getAccessToken()).replace("NEXT_OPENID", ""));
			} catch (Exception e) {
				System.out.println("请求失败!");
				e.printStackTrace();
			}
			wu.setTotal(weixinuser.getTotal());
			wu.setCount(weixinuser.getCount());
			wu.setSubscribe(jsonObject.getInt("subscribe"));
			wu.setOpenId(jsonObject.getString("openid"));
			wu.setNickname(jsonObject.getString("nickname"));
			wu.setSex(jsonObject.getInt("sex"));
			wu.setLanguage(jsonObject.getString("language"));
			wu.setCity(jsonObject.getString("city"));
			wu.setProvince(jsonObject.getString("province"));
			wu.setCountry(jsonObject.getString("country"));
			wu.setHeadImgUrl(jsonObject.getString("headimgurl"));
			wu.setSubscribe(jsonObject.getInt("subscribe_time"));
		
			return wu;
		}

		public List<WeixinUser> findAllUser(){
			List<WeixinUser> userList=new ArrayList<WeixinUser>();
			userList=baseDao.findAll(WeixinUser.class, "findAllUser");
			return userList;
			
		}

		public int findUserCount() {
			int count=(int) baseDao.findOne(WeixinUser.class, "findUserCount");
			return count;
		}

		public void addUser(WeixinUser weixinuser) {
			baseDao.save(weixinuser, "addUser");
		}
			
	

		@Override
		public void deleteUser(WeixinUser weixinuser) {
			baseDao.del(weixinuser, "deleteUser");
		
			
		}

		

		@Override
		public List<WeixinUser> getAllUser() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public WeixinUser getUserByOpenid() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public WeixinUser findUser(WeixinUser weixinUser) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void updateUser(WeixinUser weixinUser) {
			// TODO Auto-generated method stub
			
		}

	

	


}
