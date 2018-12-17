package com.pb.service;

import com.pb.dao.BookDao;
import com.pb.dao.impl.BookDaoImpl;
import com.pb.entity.Book;
import com.pb.web.CriteriaBook;
import com.pb.web.Page;
import com.pb.web.ShoppingCart;

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
}
