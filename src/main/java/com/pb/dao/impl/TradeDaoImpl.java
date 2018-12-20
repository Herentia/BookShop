package com.pb.dao.impl;

import com.pb.dao.TradeDao;
import com.pb.entity.Trade;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author haohan
 * 12/18/2018 - 04:35 下午
 */
public class TradeDaoImpl extends BaseDao<Trade> implements TradeDao {

    @Override
    public void insert(Trade trade) {
        String sql = "insert into trade (userid, tradetime) values (?,?)";
        long tradeId = insert(sql, trade.getUserId(), trade.getTradeTime());
        trade.setTradeId((int)tradeId);
    }

    @Override
    public Set<Trade> getTradeWithUserId(Integer userId) {
        String sql = "select tradeId, tradeTime, userId from trade where userId = ？";
        return new HashSet<>(queryForList(sql, userId));
    }
}
