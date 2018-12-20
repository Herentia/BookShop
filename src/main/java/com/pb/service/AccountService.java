package com.pb.service;

import com.pb.dao.AccountDao;
import com.pb.dao.impl.AccountDaoImpl;
import com.pb.entity.Account;

/**
 * @author haohan
 * 12/18/2018 - 03:07 下午
 */
public class AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    public Account getAccount(Integer accountId) {
        return accountDao.get(accountId);
    }

}
