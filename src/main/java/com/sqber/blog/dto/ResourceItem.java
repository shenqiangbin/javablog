package com.sqber.blog.dto;

import java.text.MessageFormat;

/*
 * Java资源项
 * */
public class ResourceItem {
	private int id;
	private String name;
	private String url;

	public ResourceItem() {
		
	}
	
	public ResourceItem(String name,String url) {
		this.name = name;
		this.url = url;
	}
	
	public int getId() {
		return this.id;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return MessageFormat.format("name:{0},url:{1}", this.name,this.url);
	}
}
