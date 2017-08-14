package com.yc.bean;

import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable{
	private static final long serialVersionUID = -8981037255405066428L;
	
	private Integer aid;
	private String   aname;
	private String  apwd;
	private String  telephone;
	private Date  regtime;
	private Date lastupdatetime;
	private Integer  typeid;
	
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getRegtime() {
		return regtime;
	}
	public void setRegtime(Date regtime) {
		this.regtime = regtime;
	}
	public Date getLastupdatetime() {
		return lastupdatetime;
	}
	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", apwd=" + apwd + ", telephone=" + telephone + ", regtime="
				+ regtime + ", lastupdatetime=" + lastupdatetime + ", typeid=" + typeid + "]";
	}


}
