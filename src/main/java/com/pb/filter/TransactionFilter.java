package com.pb.filter;

import com.pb.utils.JDBCUtil;
import com.pb.web.ConnectionContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author haohan
 * 12/20/2018 - 10:32 上午
 * 事务管理过滤器，通过ThreadLocal存储Conncetion,来使一次结账请求来自同一个conn
 * 以达到对一次结账请求的事务管理
 */
public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Connection conn = null;
        try {
            //1、获取连接
            conn = JDBCUtil.getConn();
            //2、开启事务
            conn.setAutoCommit(false);
            //3、利用ThreadLocal把当前连接和当前线程绑定
            ConnectionContext.getInstance().bind(conn);
            //4、把请求转给目标servlet
            filterChain.doFilter(servletRequest, servletResponse);
            //5、没有报错时提交事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //6、回滚事务
            try {
                conn.rollback();
                //重定向到错误提示页面
                HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
                HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/error-1.jsp");
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            //7、关闭连接
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
