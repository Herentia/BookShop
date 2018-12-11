package com.pb.dao;

import com.pb.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author haohan
 * 12/11/2018 - 10:44 上午
 * DAO接口的实现类
 */
public class BaseDao<T> implements Dao<T> {

    private QueryRunner queryRunner = new QueryRunner();

    public long insert(String sql, Object... args) {
        Connection conn = null;
        //由于QueryRunner的update没有返回值,所以使用原始JDBC来实现
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(conn);
        }
        return 0;
    }

    public void update(String sql, Object... args) {
        Connection conn = null;

        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(conn);
        }
    }

    public T query(String sql, Object... args) {
        Connection conn = null;

        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(conn);
        }
        return null;
    }

    public List<T> queryForList(String sql, Object... args) {
        Connection conn = null;

        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(conn);
        }
        return null;
    }

    public <V> V getSingleVal(String sql, Object... args) {
        Connection conn = null;

        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(conn);
        }
        return null;
    }

    public void batch(String sql, Object... args) {
        Connection conn = null;

        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(conn);
        }
    }
}
