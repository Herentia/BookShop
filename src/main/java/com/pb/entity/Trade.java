package com.pb.entity;

import java.util.Date;

/**
 * @author haohan
 * 12/11/2018 - 04:00 下午
 */
public class Trade {

    private int tradeId;
    private Date tradeTime;
    private int userId;

    public Trade() {
    }

    public Trade(int tradeId, Date tradeTime, int userId) {
        this.tradeId = tradeId;
        this.tradeTime = tradeTime;
        this.userId = userId;
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public Date getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(Date tradeTime) {
        this.tradeTime = tradeTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", tradeTime=" + tradeTime +
                ", userId=" + userId +
                '}';
    }
}
