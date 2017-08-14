package com.yc.biz;

import java.util.List;

import com.yc.bean.WeixinUser;

public interface WeixinUserBiz {

	///数据库刷新用户
	 public void refreshUser();
	 //从用户列表查所有用户
	 public List<WeixinUser> findAllUser();
	 //查询用户数量
	 public	int findUserCount();
	 //添加用户
	 public void addUser(WeixinUser weixinUser);
	 //删除用户
	 public void deleteUser(WeixinUser weixinuser);
	 //得到当前在线用户
	 public WeixinUser getWechatUser(WeixinUser weixinuser);
	
		 // 请求用户列表
		public List<WeixinUser> getAllUser();
	
		 // 查询某个用户
		public WeixinUser getUserByOpenid();
		public WeixinUser findUser(WeixinUser weixinUser);
		//更新用户
		public void updateUser(WeixinUser weixinUser);
		

}
