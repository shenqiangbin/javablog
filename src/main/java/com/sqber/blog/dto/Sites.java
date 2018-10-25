package com.sqber.blog.dto;

import java.text.MessageFormat;
import java.util.Date;

public class Sites {
	private int id;
	private String name;
	private String registerUrl;
	private String siteUrl;
	private String number;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRegisterUrl() {
		return registerUrl;
	}


	public void setRegisterUrl(String registerUrl) {
		this.registerUrl = registerUrl;
	}


	public String getSiteUrl() {
		return siteUrl;
	}


	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public Date getCompleteTime() {
		return completeTime;
	}


	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}


	public Date getAddTime() {
		return addTime;
	}


	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}


	private Date completeTime;
	private Date addTime;

	
	@Override
	public String toString() {
		return MessageFormat.format("name:{0},url:{1}", this.name,this.siteUrl);
	}
}
