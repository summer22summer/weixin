package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.bean.AdminType;
import com.yc.biz.AdminTypeBiz;
import com.yc.dao.BaseDao;


@Service
public class AdminTypeBizImpl implements AdminTypeBiz {
	@Resource(name="baseDao")
	private BaseDao baseDao;
	
	/**
	 * 获取所有的管理员类别
	 */
	@Override
	public List<AdminType> getTypeList() {
		List<AdminType> types=null;
		types=this.baseDao.findAll(AdminType.class, "getAllAdminType");
		return types;
	}

}
