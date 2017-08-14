package com.yc.biz;

import java.util.List;

import com.yc.bean.AdminType;


public interface AdminTypeBiz {
	/**
	 * 查询所有的管理员类别
	 * @return
	 */
	public List<AdminType> getTypeList();

}
