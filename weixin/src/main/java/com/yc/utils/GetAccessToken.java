package com.yc.utils;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import org.apache.http.ParseException;
import com.yc.bean.AccessToken;
import com.yc.biz.AccessTokenBiz;

public class GetAccessToken implements Serializable {
	
	
	public static String getAT( AccessTokenBiz  accesstokenBiz  ) throws ParseException, IOException, java.text.ParseException{
		AccessToken accesstoken = accesstokenBiz.serachAccessToken();
		
//		System.out.println( accesstoken.getAccess_token() );
		//进行判断assesstoken是否过期
		long dtime = CommonDateUtils.StrDateFormat( accesstoken.getLastModifytime().toString()).getTime();
		//根据当前时间戳减去数据库中的时间
		double time = (System.currentTimeMillis()-dtime)/3600/1000;
//		System.out.println( "时间差为:"+ time);
		//如果大于两小时则更新数据库
		if( time>2.0 ){
			accesstokenBiz.updateAccessToken();
			//更新数据库后重新获取
			AccessToken newAccesstoken = accesstokenBiz.serachAccessToken();
			return newAccesstoken.getAccessToken();
		}
		return accesstoken.getAccessToken();
	}
}
