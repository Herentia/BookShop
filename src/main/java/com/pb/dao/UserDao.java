package com.pb.dao;

import com.pb.entity.User;

/**
 * @author haohan
 * 12/18/2018 - 09:26 上午
 */
public interface UserDao {

    /**
     * 根据用户名获取User对象
     * @param username
     * @return
     */
    public abstract User getUser(String username);

}
