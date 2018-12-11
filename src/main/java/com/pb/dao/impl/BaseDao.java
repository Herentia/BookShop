package com.pb.dao.impl;

import com.pb.dao.Dao;
import com.pb.utils.JDBCUtil;
import com.pb.utils.ReflectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * @author haohan
 * 12/11/2018 - 10:44 上午
 * DAO接口的实现类
 */
public class BaseDao<T> implements Dao<T> {

    private QueryRunner queryRunner = new QueryRunner();

    private Class<T> clazz;

    public BaseDao() {
        clazz = ReflectionUtils.getSuperClassGenricType(getClass());
    }

    public long insert(String sql, Object... args) {
        Connection conn = null;
        //由于QueryRunner的update没有返回值,所以使用原始JDBC来实现
        PreparedStatement ps = null;
        ResultSet rs = null;
        long id = 0;

        try {
            conn = JDBCUtil.getConn();
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            if(args != null) {
                for(int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            ps.executeUpdate();
            //获取生成的主键值
            rs = ps.getGeneratedKeys();
            while(rs.next()) {
                id = rs.getLong(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(conn, ps, rs);
        }
        return 0;
    }

    public void update(String sql, Object... args) {
        Connection conn = null;

        try {
            conn = JDBCUtil.getConn();
            queryRunner.update(conn, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(conn);
        }
    }

    public T query(String sql, Object... args) {
        Connection conn = null;

        try {
            conn = JDBCUtil.getConn();
            return queryRunner.query(conn, sql, new BeanHandler<>(clazz), args);
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
            conn = JDBCUtil.getConn();
            return queryRunner.query(conn, sql, new BeanListHandler<>(clazz), args);
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
            conn = JDBCUtil.getConn();
            return (V) queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(conn);
        }
        return null;
    }

    public void batch(String sql, Object[] ... params) {
        Connection conn = null;

        try {
            conn = JDBCUtil.getConn();
//            queryRunner.batch(conn, sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConn(conn);
        }
    }
}
