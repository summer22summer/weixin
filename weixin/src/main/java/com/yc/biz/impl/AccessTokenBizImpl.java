package com.yc.biz.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.http.ParseException;
import org.springframework.stereotype.Service;

import com.yc.bean.AccessToken;
import com.yc.biz.AccessTokenBiz;
import com.yc.dao.BaseDao;
import com.yc.utils.WeixinUtil;
@Service
public class AccessTokenBizImpl implements AccessTokenBiz{

	@Resource(name="baseDao")
	private BaseDao baseDao;
	
	@Override
	public AccessToken serachAccessToken() {
		AccessToken at=(AccessToken) baseDao.findOne(new AccessToken(), "searchAccessToken");
		if(at!=null){
			return  at;
		}
	
		return null;
	}

	@Override
	public void addAccessToken(AccessToken accesstoken) {
		baseDao.save(accesstoken,"accesstoken");
		
	}

	@Override
	public void updateAccessToken() throws ParseException, IOException {
		AccessToken accesstoken=WeixinUtil.getAccessToken();
		baseDao.update(accesstoken, "updateAccessToken");
		
	}

}
