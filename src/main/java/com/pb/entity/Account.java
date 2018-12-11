package com.pb.entity;

/**
 * @author haohan
 * 12/11/2018 - 03:57 下午
 */
public class Account {

    private int accountId;
    private int banlance;

    public Account() {
    }

    public Account(int accountId, int banlance) {
        this.accountId = accountId;
        this.banlance = banlance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getBanlance() {
        return banlance;
    }

    public void setBanlance(int banlance) {
        this.banlance = banlance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", banlance=" + banlance +
                '}';
    }
}
