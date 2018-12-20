package com.pb.dao;

import com.pb.entity.TradeItem;

import java.util.Collection;
import java.util.Set;

/**
 * @author haohan
 * 12/18/2018 - 09:26 上午
 */
public interface TradeItemDao {

    /**
     * 批量保存TradeItem对象
     * @param items
     */
    public abstract void batchSave(Collection<TradeItem> items);

    /**
     * 根据TradeId获取和其关联的TradeItem集合
     * @param tradeId
     * @return
     */
    public abstract Set<TradeItem> getTradeItemsWithTradeId(Integer tradeId);

}
