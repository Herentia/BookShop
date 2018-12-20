package com.pb.service;

import com.pb.dao.*;
import com.pb.dao.impl.*;
import com.pb.entity.Book;
import com.pb.entity.ShoppingCartItem;
import com.pb.entity.Trade;
import com.pb.entity.TradeItem;
import com.pb.web.CriteriaBook;
import com.pb.web.Page;
import com.pb.web.ShoppingCart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author haohan
 * 12/12/2018 - 03:08 下午
 */
public class BookService {

    private BookDao bd = new BookDaoImpl();

    /**
     * 获取分页页面信息
     * @param cb
     * @return
     */
    public Page<Book> getPage(CriteriaBook cb) {
        Page<Book> page = bd.getPage(cb);
        return page;
    }

    /**
     * 获取选中book信息
     * @param id
     * @return
     */
    public Book getBook(Integer id) {
        Book book = bd.getBook(id);
        return book;
    }

    /**
     * 将商品放入购物车
     * @param id 商品ID
     * @param shoppingCart 购物车
     */
    public boolean addToCart(Integer id, ShoppingCart shoppingCart) {
        Book book = bd.getBook(id);
        if(book != null) {
            shoppingCart.add(book);
            return true;
        }
        return false;
    }

    /**
     * 删除购物车中指定商品
     * @param shoppingCart
     * @param id
     */
    public void remove(ShoppingCart shoppingCart, Integer id) {
        shoppingCart.removeItem(id);
    }

    /**
     * 清空购物车
     * @param shoppingCart
     */
    public void clear(ShoppingCart shoppingCart) {
        shoppingCart.clear();
    }

    /**
     * 修改购物车商品数量
     * @param id
     * @param quantity
     */
    public void updateItemQuantity(ShoppingCart sc, int id, int quantity) {
        sc.updateItemQuantity(id, quantity);
    }

    /**
     * 结账操作
     * 1、更新bs_book表相关记录的salesamount和storeNumber 的值
     * 2、更新account表的balance（余额）
     * 3、向trade数据表插入一条记录
     * 4、向tradeItem表插入N条记录
     * 5、清空购物车
     */
    AccountDao      accountDao       = new AccountDaoImpl();
    TradeDao        tradeDao         = new TradeDaoImpl();
    UserDao         userDao          = new UserDaoImpl();
    TradeItemDao    tradeItemDao     = new TradeItemDaoImpl();
    public void cash(ShoppingCart shoppingCart, String username, String accountId) {
        //更新salesamount和storeNumber的值
        bd.batchUpdateStoreNumberAndSalesAmount(shoppingCart.getItems());
        //更新account表的balance（余额）
        accountDao.updateBalance(Integer.parseInt(accountId), shoppingCart.getTotalMoney());
        //向trade数据表插入一条记录
        Trade trade = new Trade();
        trade.setTradeTime(new Date(new java.util.Date().getTime()));
        trade.setUserId(userDao.getUser(username).getUserId());
        tradeDao.insert(trade);
        //向tradeItem表插入N条记录
        Collection<TradeItem> items = new ArrayList<>();
        for(ShoppingCartItem sci : shoppingCart.getItems()) {
            TradeItem tradeItem = new TradeItem();
            tradeItem.setBookId(sci.getBook().getId());
            tradeItem.setQuantity(sci.getQuantity());
            tradeItem.setTradeId(trade.getTradeId());
            items.add(tradeItem);
        }
        tradeItemDao.batchSave(items);

        //清空购物车
        shoppingCart.clear();

    }
}
