package com.pb.dao;

import java.util.List;

/**
 * @author haohan
 * 12/11/2018 - 09:34 上午
 * Dao接口，定义Dao的基本操作，由BaseDao提供实现
 */
public interface Dao<T> {

    /**
     * 执行insert，回返插入后记录的ID
     */
    long insert(String sql, Object ... args);

    /**
     * 执行update操作，包括insert（没有返回值），update、delete
     */
    void update(String sql, Object ... args);

    /**
     * 执行单条记录的查询操作，返回与记录对应的类的对象
     */
    T query(String sql, Object ... args);

    /**
     * 执行多条记录的查询操作，返回与记录对应类的List对象
     */
    List<T> queryForList(String sql, Object ... args);

    /**
     * 执行一个属性或值的查询操作，例如查询某个字段
     */
    <V> V getSingleVal(String sql, Object ... args);

    /**
     * 执行批量更新操作
     */
    void batch(String sql, Object[] ... args);

}
