package com.pb.entity;

/**
 * @author haohan
 * 12/14/2018 - 01:35 下午
 * 加入购物车的同种商品信息
 */
public class ShoppingCartItem {

    private Book book;      //加入购物车书本信息
    private int quantity;   //加入数量

    public ShoppingCartItem(Book book) {
        this.book = book;
        this.quantity = 1;//加入书本进购物车时，将书本数量初始化为1
    }

    /**
     * 获取书本信息
     * @return book对象
     */
    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取这个书本的总价格
     * @return
     */
    public float getItemMoney() {
        return (float) (quantity * book.getPrice());
    }

    /**
     * 增加书本数量
     */
    public void incerment() {
        quantity++;
    }

}
