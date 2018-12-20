package com.pb.dao.impl;

import com.pb.dao.TradeItemDao;
import com.pb.entity.TradeItem;

import java.util.*;

/**
 * @author haohan
 * 12/19/2018 - 10:29 上午
 */
public class TradeItemDaoImpl extends BaseDao<TradeItem> implements TradeItemDao {

    @Override
    public void batchSave(Collection<TradeItem> items) {
        String sql = "insert into tradeitem(quantity, bookid, tradeid) values (?, ?, ?)";
        Object[][] params = new Object[items.size()][3];
        List<TradeItem> tradeItemList = new ArrayList<>(items);
        for(int i = 0; i < tradeItemList.size(); i++) {
            params[i][0] = tradeItemList.get(i).getQuantity();
            params[i][1] = tradeItemList.get(i).getBookId();
            params[i][2] = tradeItemList.get(i).getTradeId();
        }
        batch(sql, params);
    }

    @Override
    public Set<TradeItem> getTradeItemsWithTradeId(Integer tradeId) {
        String sql = "select quantity, tradeId, bookId from tradeItem where tradeId = ?";
        return new HashSet<>(queryForList(sql, tradeId));
    }
}
