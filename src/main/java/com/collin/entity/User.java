package com.collin.entity;

import java.io.Serializable;

/**
 * Created by 10848 on 2016/11/30.
 */
public class User implements Serializable{

    private static final long serialVersionUID = 4236265357506873901L;
//
//    public User(String userName, String userSubject, String userProject, String userId, String userOffice, String userEmail, String userTime){
//        setUserName(userName);
//        setUserProject(userProject);
//        setUserSubject(userSubject);
//    }

    public User(String userPw, String userId) {
        setUserId(userId);
        setUserPw(userPw);
    }

    public User() {
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    private String userPw;

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    private String userTitle;
    private String userId;
    private String userName;
    private String userSubject;
    private String userProject;

    public User(String userTitle, String userId, String userName, String userSubject, String userProject, String userEmail, String userOffice, String userTime) {
        this.userTitle = userTitle;
        this.userId = userId;
        this.userName = userName;
        this.userSubject = userSubject;
        this.userProject = userProject;
        this.userEmail = userEmail;
        this.userOffice = userOffice;
        this.userTime = userTime;
    }

    public User(String userPw, String userTitle, String userId, String userName, String userSubject, String userProject, String userEmail, String userOffice, String userTime) {
        this.userPw = userPw;
        this.userTitle = userTitle;
        this.userId = userId;
        this.userName = userName;
        this.userSubject = userSubject;
        this.userProject = userProject;
        this.userEmail = userEmail;
        this.userOffice = userOffice;
        this.userTime = userTime;
    }

    private String userEmail;
    private String userOffice;
    private String userTime;

//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSubject() {
        return userSubject;
    }

    public void setUserSubject(String userSubject) {
        this.userSubject = userSubject;
    }

    public String getUserProject() {
        return userProject;
    }

    public void setUserProject(String userProject) {
        this.userProject = userProject;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserOffice() {
        return userOffice;
    }

    public void setUserOffice(String userOffice) {
        this.userOffice = userOffice;
    }

    public String getUserTime() {
        return userTime;
    }

    public void setUserTime(String userTime) {
        this.userTime = userTime;
    }
}
