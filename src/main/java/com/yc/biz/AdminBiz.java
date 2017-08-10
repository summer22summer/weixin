package com.yc.biz;

import com.yc.bean.Admin;

public interface AdminBiz {

	/**
	 * 登录
	 * @param voteUser
	 * @return
	 * @throws Exception
	 */
	public Admin login(Admin admin) throws Exception;
	

	/**
	 * 检查用户名是否被占用
	 * @param user
	 * @return
	 */
	public Admin isUsernameExist(Admin admin)throws Exception;

}
