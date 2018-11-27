package com.sqber.blog.dto;

import java.util.List;

public class ArticleSave {
	
	private String articleId;
	private String title;
	private String content;
	private List<Integer> lables;
	private String keyWords;
	private String urlTitle;
	
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Integer> getLables() {
		return lables;
	}
	public void setLables(List<Integer> lables) {
		this.lables = lables;
	}
	public String getKeyWords() {
		return keyWords;
	}
	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}
	public String getUrlTitle() {
		return urlTitle;
	}
	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}
	
	
}
