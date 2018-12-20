package com.pb.dao.impl;

import com.pb.dao.AccountDao;
import com.pb.entity.Account;

/**
 * @author haohan
 * 12/18/2018 - 10:17 上午
 */
public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {

    @Override
    public Account get(Integer accountId) {
        String sql = "select accountId, amount from bk_account where accountId = ?";
        return query(sql, accountId);
    }

    @Override
    public void updateBalance(Integer accountId, float amount) {
        String sql = "update account set balance = balance - ? where accountId = ?";
        update(sql, amount, accountId);
    }
}
