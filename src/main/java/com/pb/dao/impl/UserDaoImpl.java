package com.pb.dao.impl;

import com.pb.dao.UserDao;
import com.pb.entity.User;

/**
 * @author haohan
 * 12/18/2018 - 10:42 上午
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public User getUser(String username) {
        String sql = "select userId, userName, accountId from bk_user where username = ?";
        return query(sql, username);
    }

}
