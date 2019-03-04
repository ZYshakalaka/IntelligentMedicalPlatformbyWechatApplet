package com.zy.core.model;

import java.util.Date;

public class Press {
    private Integer id;

    private String userId;

    private Integer userPressH;

    private Integer userPressL;

    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUserPressH() {
        return userPressH;
    }

    public void setUserPressH(Integer userPressH) {
        this.userPressH = userPressH;
    }

    public Integer getUserPressL() {
        return userPressL;
    }

    public void setUserPressL(Integer userPressL) {
        this.userPressL = userPressL;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}