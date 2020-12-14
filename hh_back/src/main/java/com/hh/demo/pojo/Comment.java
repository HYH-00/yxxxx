package com.hh.demo.pojo;

import lombok.Data;

@Data
public class Comment {
    private int commentId;
    private String content;
    private int wechatmomentsId;
    private String respondents;
    private String recipient;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWechatmomentsId() {
        return wechatmomentsId;
    }

    public void setWechatmomentsId(int wechatmomentsId) {
        this.wechatmomentsId = wechatmomentsId;
    }

    public String getRespondents() {
        return respondents;
    }

    public void setRespondents(String respondents) {
        this.respondents = respondents;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
}