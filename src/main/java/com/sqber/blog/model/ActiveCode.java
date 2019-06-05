package com.sqber.blog.model;

import java.util.Date;

public class ActiveCode {

    private int id;
    private String code;
    private String publicAccount;
    private String user;
    private int status;
    private Date userGetCodeTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPublicAccount() {
        return publicAccount;
    }

    public void setPublicAccount(String publicAccount) {
        this.publicAccount = publicAccount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getUserGetCodeTime() {
        return userGetCodeTime;
    }

    public void setUserGetCodeTime(Date userGetCodeTime) {
        this.userGetCodeTime = userGetCodeTime;
    }
}
