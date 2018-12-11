package com.pb.utils;

import java.sql.Connection;

/**
 * @author haohan
 * 12/11/2018 - 11:19 上午
 */
public class JDBCUtil {

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
