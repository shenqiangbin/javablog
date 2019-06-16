package com.sqber.blog.model;

import java.util.Date;

public class Cartoon {
    private int id;
    private String name;
    private String img;
    private int hotLevel;
    private String doudouHref;
    private int doudouSyncNum;
    private String source;
    private Date createTime;
    private Date updateTime;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getHotLevel() {
        return hotLevel;
    }

    public void setHotLevel(int hotLevel) {
        this.hotLevel = hotLevel;
    }

    public String getDoudouHref() {
        return doudouHref;
    }

    public void setDoudouHref(String doudouHref) {
        this.doudouHref = doudouHref;
    }

    public int getDoudouSyncNum() {
        return doudouSyncNum;
    }

    public void setDoudouSyncNum(int doudouSyncNum) {
        this.doudouSyncNum = doudouSyncNum;
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

    @Override
    public String toString() {
        return "Cartoon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", hotLevel=" + hotLevel +
                ", doudouHref='" + doudouHref + '\'' +
                ", doudouSyncNum=" + doudouSyncNum +
                ", source='" + source + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
