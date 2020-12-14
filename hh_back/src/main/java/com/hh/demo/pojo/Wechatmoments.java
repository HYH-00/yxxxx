package com.hh.demo.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Wechatmoments {
    private String userId;
    private String userNickName;
    private String content;
    private String date;
    private int wechatmomentsId;
    private int fabulous;
    private List<String> fabulousNick;
    private List<Comment> comment;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWechatmomentsId() {
        return wechatmomentsId;
    }

    public void setWechatmomentsId(int wechatmomentsId) {
        this.wechatmomentsId = wechatmomentsId;
    }

    public int getFabulous() {
        return fabulous;
    }

    public void setFabulous(int fabulous) {
        this.fabulous = fabulous;
    }

    public List<String> getFabulousNick() {
        return fabulousNick;
    }

    public void setFabulousNick(List<String> fabulousNick) {
        this.fabulousNick = fabulousNick;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
