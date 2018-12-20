package com.pb.dao;

import com.pb.entity.Trade;

import java.util.Set;

/**
 * @author haohan
 * 12/18/2018 - 09:25 上午
 */
public interface TradeDao {

    /**
     * 向数据表中插入Trade对象
     * @param trade
     */
    public abstract void insert(Trade trade);

    /**
     * 根据UserId获取和其关联的Trade的集合
     * @param userId
     * @return
     */
    public abstract Set<Trade> getTradeWithUserId(Integer userId);

}
