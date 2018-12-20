package com.pb.dao;

import com.pb.entity.Account;

/**
 * @author haohan
 * 12/18/2018 - 09:25 上午
 */
public interface AccountDao {

    /**
     * 根据accountId获取对应的Account对象
     * @param accountId
     * @return
     */
    public abstract Account get(Integer accountId);

    /**
     * 更新指定账户的余额，扣除amount指定的钱数
     * @param accountId
     * @param amount
     */
    public abstract void updateBalance(Integer accountId, float amount);

}
