package com.yc.bean;

import java.io.Serializable;
import java.util.Date;

public class AdminType implements Serializable{
	private static final long serialVersionUID = 8321521101226625751L;
	
	private Integer typeid;
	private Date	regtime;
	private String typename;
	
	
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	@Override
	public String toString() {
		return "AdminType [typeid=" + typeid + ", regtime=" + regtime + ", typename=" + typename + "]";
	}

}
