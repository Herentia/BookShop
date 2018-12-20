package com.pb.servlet;

import com.pb.entity.User;
import com.pb.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author haohan
 * 12/20/2018 - 01:44 下午
 * 通过用户名查询用户的购买信息
 */
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 8862415738876942731L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过用户名获取用户信息
        String username = req.getParameter("username");

        User user = userService.getUserWithTrade(username);
        //当user为空时，重定向到提示页面
        if(user == null) {
            resp.sendRedirect(req.getContextPath() + "/error-1.jsp");
            return;
        }
        //不为空时，存入request中，并转到指定页面
        req.setAttribute("user", user);

        req.getRequestDispatcher("/WEB-INF/bookshop/trade.jsp").forward(req, resp);
    }
}
