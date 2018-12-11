package com.pb.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author haohan
 * 12/11/2018 - 11:19 上午
 */
public class JDBCUtil {

    private static DataSource dataSource = null;

    static {
        //数据源只能被创建一次
        dataSource = new ComboPooledDataSource("bookshop");
    }

    /**
     * 获取数据库连接
     * @return
     * @throws SQLException
     */
    public static Connection getConn() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 关闭数据库连接，释放资源
     */
    public static void closeConn(Connection conn) {
        try{
            if(conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
