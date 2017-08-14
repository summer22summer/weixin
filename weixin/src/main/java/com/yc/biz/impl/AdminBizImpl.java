package com.yc.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Admin;
import com.yc.biz.AdminBiz;
import com.yc.dao.BaseDao;
import com.yc.utils.Encrypt;


@Service
public class AdminBizImpl implements AdminBiz{
	@Resource(name="baseDao")
	private BaseDao baseDao;

	
	/**
	 * 管理员登录（密码加密
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Admin login(Admin admin) throws Exception {
		admin.setApwd(Encrypt.md5AndSha(admin.getApwd()));
		Admin ad = (Admin) this.baseDao.findOne(admin, "getAdminByLogin");
		return ad;
	}

	/**
	 * 判断管理员名是否已被占用(root的权限，root可以创建admin账号
	 */
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Admin isUsernameExist(Admin admin) throws Exception {
		Admin ad = (Admin) this.baseDao.findOne(admin, "isAdminExists");
		return ad;
	}

}
