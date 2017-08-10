package com.yc.biz;

import java.io.IOException;
import org.apache.http.ParseException;
import com.yc.bean.AccessToken;

public interface AccessTokenBiz {
	
	//查找  只有一个公众号！不需要参数
	public AccessToken serachAccessToken(  );
	
	//增加
	public void addAccessToken(AccessToken accesstoken);
	
	//更新  
	public void updateAccessToken(  ) throws ParseException, IOException;
	
}
