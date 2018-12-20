package com.pb.web;

import java.sql.Connection;

/**
 * @author haohan
 * 12/20/2018 - 11:07 上午
 * Connection存入ThreadLocal，使每个多线程都能只用当前线程对应的conn
 * 由于每一个线程对应一个自己的连接，所以该类为单列模式
 */
public class ConnectionContext {

    private ConnectionContext() {}

    private static ConnectionContext instance = new ConnectionContext();

    public static ConnectionContext getInstance() {
        return instance;
    }

    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    /**
     * 将当前连接与当前线程进行绑定
     * @param connection 需要存入的Connection对象
     */
    public void bind(Connection connection) {
        connectionThreadLocal.set(connection);
    }

    /**
     * 取出当前线程中绑定的连接
     * @return
     */
    public Connection get() {
        return connectionThreadLocal.get();
    }

    /**
     * 清除当前线程中的连接
     */
    public void remove() {
        connectionThreadLocal.remove();
    }


}
