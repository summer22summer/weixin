package com.yc.biz.impl;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.http.ParseException;

import com.yc.bean.AccessToken;
import com.yc.biz.AccessTokenBiz;
import com.yc.dao.BaseDao;
import com.yc.utils.HttpUtil;


@Service
public class AccessTokenBizImpl implements AccessTokenBiz {

	@Resource(name="baseDao")
	private BaseDao baseDao;
	
	//查询token
	@Override
	public AccessToken serachAccessToken( ) {
		AccessToken at = (AccessToken) baseDao.findOne(new AccessToken(), "serachAccessToken");
		if( at!=null ){
			return at;
		}
		
		return null;
	}
	
	//增加accesstoken
	@Override
	public void addAccessToken(AccessToken accesstoken) {
		baseDao.save(accesstoken, "addAccessToken");

	}
	
	//更新
	@Override
	public void updateAccessToken( ) throws ParseException, IOException {
		AccessToken token = HttpUtil.getAccessToken();
		baseDao.update( token , "updateAccessToken");
	}

	
}
