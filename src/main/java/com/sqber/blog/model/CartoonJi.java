package com.sqber.blog.model;


import java.util.Date;

public class CartoonJi {
    private int id;
    private int cartoonId;
    private String jiName;
    private String linename;
    private String pageHref;
    private String firstSrc;
    private String trueSrc;
    private String source;
    private Date createTime;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartoonId() {
        return cartoonId;
    }

    public void setCartoonId(int cartoonId) {
        this.cartoonId = cartoonId;
    }

    public String getJiName() {
        return jiName;
    }

    public void setJiName(String jiName) {
        this.jiName = jiName;
    }

    public String getLinename() {
        return linename;
    }

    public void setLinename(String linename) {
        this.linename = linename;
    }

    public String getPageHref() {
        return pageHref;
    }

    public void setPageHref(String pageHref) {
        this.pageHref = pageHref;
    }

    public String getFirstSrc() {
        return firstSrc;
    }

    public void setFirstSrc(String firstSrc) {
        this.firstSrc = firstSrc;
    }

    public String getTrueSrc() {
        return trueSrc;
    }

    public void setTrueSrc(String trueSrc) {
        this.trueSrc = trueSrc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
