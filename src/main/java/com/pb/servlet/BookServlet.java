package com.pb.servlet;

import com.pb.entity.Book;
import com.pb.service.BookService;
import com.pb.utils.BookStoreWebUtils;
import com.pb.web.CriteriaBook;
import com.pb.web.Page;
import com.pb.web.ShoppingCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author haohan
 * 12/12/2018 - 03:20 下午
 */
public class BookServlet extends HttpServlet {

    private BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String methodName = req.getParameter("method");
        try {
            Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
//            // 利用反射获取方法
//            Method method = getClass().getDeclaredMethod(methodName,
//                    HttpServletRequest.class, HttpServletResponse.class);
//            // 执行相应的方法
//            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取书本分页信息
     */
    public void getBooks(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNoStr = req.getParameter("pageNo");
        String minPriceStr = req.getParameter("minPrice");
        String maxPriceStr = req.getParameter("maxPrice");

        int pageNo = 1;
        int minPrice = 0;
        int maxPrice = Integer.MAX_VALUE;

        try {
            pageNo = Integer.parseInt(pageNoStr);
        } catch (NumberFormatException e) {}
        try {
            minPrice = Integer.parseInt(minPriceStr);
        } catch (NumberFormatException e) {}
        try {
            maxPrice = Integer.parseInt(maxPriceStr);
        } catch (NumberFormatException e) {}

        CriteriaBook cb = new CriteriaBook(minPrice, maxPrice, pageNo);

        Page<Book> page = bookService.getPage(cb);

        req.setAttribute("bookpage", page);
        req.getRequestDispatcher("/WEB-INF/bookshop/books.jsp").forward(req, resp);
    }

    /**
     * 通过ID获取对应的书本信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookIdStr = req.getParameter("bookId");
        int bookId = -1;
        Book book = null;
        try {
            bookId = Integer.parseInt(bookIdStr);
        } catch (NumberFormatException e) {}
        if(bookId > 0) {
            book = bookService.getBook(bookId);
        }

        if(book == null) {
            resp.sendRedirect(req.getContextPath() + "/error-1.jsp");
        }

        req.setAttribute("book", book);
        req.getRequestDispatcher("/WEB-INF/bookshop/book.jsp").forward(req, resp);
    }

    /**
     * 添加商品到购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void addToCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取商品的id
        String strId = req.getParameter("bookId");
        int id = -1;
        boolean flag = false;
        try {
            id = Integer.parseInt(strId);
        } catch (NumberFormatException e) {}
        if(id > 0) {
            //2、获取购物车信息
            ShoppingCart shoppingCart = BookStoreWebUtils.getShoppingCart(req);
            //3、调用bookService的addToCart方法将商品放入购物车
            flag = bookService.addToCart(id, shoppingCart);
        }
        if(flag) {
            //4、将信息传回books页面
            getBooks(req, resp);
            return;
        }
        resp.sendRedirect(req.getContextPath() + "/error-1.jsp");
    }

    /**
     * 跳转到购物车页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void toCartPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/bookshop/shoppingCart.jsp").forward(req, resp);
    }

}