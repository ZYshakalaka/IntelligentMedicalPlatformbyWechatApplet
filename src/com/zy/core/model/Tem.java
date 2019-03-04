package com.zy.core.model;

import java.util.Date;

public class Tem {
    private Integer id;

    private String userTem;

    private Date time;

    private String userId;

    private String tem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserTem() {
        return userTem;
    }

    public void setUserTem(String userTem) {
        this.userTem = userTem;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }
}