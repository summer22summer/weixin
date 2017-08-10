package com.yc.bean;

import java.io.Serializable;
import java.sql.Timestamp;

//获取assess_token存入数据库并两小时更新一次数据库
public class AccessToken implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 499999626095346849L;
	private String access_token;
	private Integer expires_in;   //数据库没有这个属性
	private Timestamp lastModifytime;
	
	
	
	public Timestamp getLastModifytime() {
		return lastModifytime;
	}

	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public Integer getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	
	
	

	
	
}
