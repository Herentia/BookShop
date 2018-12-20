package com.pb.service;

import com.pb.dao.BookDao;
import com.pb.dao.TradeDao;
import com.pb.dao.TradeItemDao;
import com.pb.dao.UserDao;
import com.pb.dao.impl.BookDaoImpl;
import com.pb.dao.impl.TradeDaoImpl;
import com.pb.dao.impl.TradeItemDaoImpl;
import com.pb.dao.impl.UserDaoImpl;
import com.pb.entity.Trade;
import com.pb.entity.TradeItem;
import com.pb.entity.User;

import java.util.Set;

/**
 * @author haohan
 * 12/18/2018 - 02:47 下午
 */
public class UserService {

    private UserDao ud = new UserDaoImpl();

    /**
     * 根据用户名来查询用户信息
     */
    public User getUserByName(String username) {
        return ud.getUser(username);
    }

    private TradeDao tradeDao = new TradeDaoImpl();
    private TradeItemDao tradeItemDao = new TradeItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    /**
     * 根据用户名查找用户购物订单信息
     */
    public User getUserWithTrade(String username) {
        //获取user对象
        User user = ud.getUser(username);
        if(user == null) {
            return null;
        }
        //获取trade集合
        Set<Trade> trades = tradeDao.getTradeWithUserId(user.getUserId());
        //获取每一个trade中的tradeitem集合
        if(trades != null) {
            for(Trade trade : trades) {
                Set<TradeItem> tradeItems = tradeItemDao.getTradeItemsWithTradeId(trade.getTradeId());
                if(tradeItems != null) {
                    for(TradeItem tradeItem : tradeItems) {
                        tradeItem.setBook(bookDao.getBook(tradeItem.getBookId()));
                    }
                    //将每个trade的item赋值给对应的trade
                    trade.setTradeItems(tradeItems);
                }
            }
        }
        //将Trade赋值给user
        user.setTrades(trades);
        return user;
    }

}
