package com.pb.web;

import com.pb.entity.Book;
import com.pb.entity.ShoppingCartItem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haohan
 * 12/14/2018 - 01:44 下午
 * 购物车类，存储购物车中所有的需要购买的书本
 */
public class ShoppingCart {

    Map<Integer, ShoppingCartItem> books = new HashMap<>();

    /**
     * 向购物车添加一件商品
     */
    public void add(Book book) {
        //先判断已有的购物车中是否有该book，有的话就只增加book数量即可
        ShoppingCartItem sci = books.get(book.getId());
        if(sci == null) {
            sci = new ShoppingCartItem(book);
            books.put(book.getId(), sci);
        } else {
            sci.incerment();
        }
    }

    /**
     * 检查购物车中是否有指定ID的书
     * @param id
     * @return
     */
    public boolean hasBook(Integer id) {
        return books.containsKey(id);
    }

    public Map<Integer, ShoppingCartItem> getBooks() {
        return books;
    }

    public Collection<ShoppingCartItem> getItems() {
        return books.values();
    }

    /**
     * 获取购物车的书本总数量
     * @return
     */
    public int getBookNumber() {
        int total = 0;
        for(ShoppingCartItem sci : books.values()) {
            total += sci.getQuantity();
        }
        return total;
    }

    public float getTotalMoney() {
        int totalMoney = 0;
        for(ShoppingCartItem sci : getItems()) {
            totalMoney += sci.getItemMoney();
        }
        return totalMoney;
    }

    public boolean isEmpty() {
        return books.isEmpty();
    }

    public void clear() {
        books.clear();
    }

    public void removeItem(int id) {
        books.remove(id);
    }

    public void updateItemQuantity(int id, int quantity) {
        ShoppingCartItem sci = books.get(id);
        if(sci != null)
            sci.setQuantity(quantity);
    }

}
