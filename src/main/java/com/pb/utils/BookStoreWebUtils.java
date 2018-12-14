package com.pb.utils;

import com.pb.web.ShoppingCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author haohan
 * 12/14/2018 - 02:18 下午
 */
public class BookStoreWebUtils {

    /**
     * 获取购物车对象，从session中获取，若session中没有则创建一个新的购物车对象，若有则直接返回
     * @return 购物车对象
     */
    public static ShoppingCart getShoppingCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ShoppingCart sc = (ShoppingCart) session.getAttribute("shoppingCart");
        if(sc == null) {
            sc = new ShoppingCart();
            session.setAttribute("shoppingCart", sc);
        }
        return sc;
    }

}
