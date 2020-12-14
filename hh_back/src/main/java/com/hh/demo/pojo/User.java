package com.hh.demo.pojo;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String userPassword;
    private double userBalance;
    private String userName;
    private String userSex;
    private String userLocation;
    private String userDocumentType;
    private String userIdentificationNumber;
    private String userNickName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public void setUserBalance(double userBalance) {
        this.userBalance = userBalance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserDocumentType() {
        return userDocumentType;
    }

    public void setUserDocumentType(String userDocumentType) {
        this.userDocumentType = userDocumentType;
    }

    public String getUserIdentificationNumber() {
        return userIdentificationNumber;
    }

    public void setUserIdentificationNumber(String userIdentificationNumber) {
        this.userIdentificationNumber = userIdentificationNumber;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }
}
