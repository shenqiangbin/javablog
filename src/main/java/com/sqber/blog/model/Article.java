package com.sqber.blog.model;

import java.util.Date;

/**
     * @author shen
     * 文章
     */
    public class Article
    {
    	private Integer ArticleId;
    	private String Title;
    	private String Content;
    	/**
    	 * 内容级别：（0：正常 1：置顶 2：精华）
    	 */
    	private Integer ContentLevel;    	
    	/**
    	 * 发布状态：（0：未发布，1：已发布）
    	 */
    	private Integer PublishStatus;
    	/**
    	 * 展示的创建时间
    	 */
    	private Date DisplayCreatedTime;
    	/**
    	 *  关键字
    	 */
    	private String KeyWords;
    	/**
    	 *  url标题
    	 */
    	private String UrlTitle;
    	/**
    	 *  url标题数字（需要唯一）
    	 */
    	private String UrlTitleNum;

    	private String CreateUser;
    	private Date CreatedTime;
    	private Date UpdateTime;
    	private int Enable;
    	
    	
		public Integer getArticleId() {
			return ArticleId;
		}
		public void setArticleId(Integer articleId) {
			ArticleId = articleId;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getContent() {
			return Content;
		}
		public void setContent(String content) {
			Content = content;
		}
		public Integer getContentLevel() {
			return ContentLevel;
		}
		public void setContentLevel(Integer contentLevel) {
			ContentLevel = contentLevel;
		}
		public Integer getPublishStatus() {
			return PublishStatus;
		}
		public void setPublishStatus(Integer publishStatus) {
			PublishStatus = publishStatus;
		}
		public Date getDisplayCreatedTime() {
			return DisplayCreatedTime;
		}
		public void setDisplayCreatedTime(Date displayCreatedTime) {
			DisplayCreatedTime = displayCreatedTime;
		}
		public String getKeyWords() {
			return KeyWords;
		}
		public void setKeyWords(String keyWords) {
			KeyWords = keyWords;
		}
		public String getUrlTitle() {
			return UrlTitle;
		}
		public void setUrlTitle(String urlTitle) {
			UrlTitle = urlTitle;
		}
		public String getUrlTitleNum() {
			return UrlTitleNum;
		}
		public void setUrlTitleNum(String urlTitleNum) {
			UrlTitleNum = urlTitleNum;
		}
		public String getCreateUser() {
			return CreateUser;
		}
		public void setCreateUser(String createUser) {
			CreateUser = createUser;
		}
		public Date getCreatedTime() {
			return CreatedTime;
		}
		public void setCreatedTime(Date createdTime) {
			CreatedTime = createdTime;
		}
		public Date getUpdateTime() {
			return UpdateTime;
		}
		public void setUpdateTime(Date updateTime) {
			UpdateTime = updateTime;
		}
		public int getEnable() {
			return Enable;
		}
		public void setEnable(int enable) {
			Enable = enable;
		}
    }

