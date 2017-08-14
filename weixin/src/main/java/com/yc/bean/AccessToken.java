package com.yc.bean;

import java.sql.Timestamp;

/**
 * 微信通用接口凭证
 *获取accesstoken并存入数据库  两个小时更新一次 
 */
public class AccessToken {
	// 获取到的凭证
	private String accesstoken;
	// 凭证有效时间，单位：秒
	private int expiresIn;
	//最后一次修改的时间
	 private Timestamp lastModifytime;

	public String getAccessToken(){
		return accesstoken;
	}

	public void setAccessToken(String accesstoken) {
		this.accesstoken = accesstoken;
	}

	public int getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	

	public String getAccesstoken() {
		return accesstoken;
	}

	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}

	public Timestamp getLastModifytime() {
		return lastModifytime;
	}

	public void setLastModifytime(Timestamp lastModifytime) {
		this.lastModifytime = lastModifytime;
	}

	@Override
	public String toString() {
		return "AccessToken [accesstoken=" + accesstoken + ", expiresIn=" + expiresIn + ", lastModifytime="
				+ lastModifytime + "]";
	}

	
}
