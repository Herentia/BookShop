package com.pb.entity;

/**
 * @author haohan
 * 12/11/2018 - 03:54 下午
 */
public class User {

    private int userId;
    private String userName;
    private int accountId;

    public User() {
    }

    public User(int userId, String userName, int accountId) {
        this.userId = userId;
        this.userName = userName;
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
