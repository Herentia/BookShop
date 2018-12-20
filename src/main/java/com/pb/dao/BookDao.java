package com.pb.dao;

import com.pb.entity.Book;
import com.pb.entity.ShoppingCartItem;
import com.pb.web.CriteriaBook;
import com.pb.web.Page;

import java.util.Collection;
import java.util.List;

/**
 * @author haohan
 * 12/11/2018 - 04:26 下午
 * 图书信息接口
 */
public interface BookDao {

    /**
     * 根据ID获取BOOK对象
     * @param id book的id
     * @return book对象
     */
    public abstract Book getBook(int id);

    /**
     * 根据传入的CriteriaBook条件对象，返回对应的Page对象
     * @param cb 查询条件
     * @return
     */
    public abstract Page<Book> getPage(CriteriaBook cb);

    /**
     * 根据传入的条件对象返回对应的总记录数
     * @param cb 查询条件
     * @return
     */
    public abstract long getTotalBookNumber(CriteriaBook cb);

    /**
     * 根据条件和每页显示的记录数返回当前页面对应的List
     * @param cb 查询条件
     * @param pageSize 每页显示记录数
     * @return
     */
    public abstract List<Book> getPageList(CriteriaBook cb, int pageSize);

    /**
     * 返回指定ID的storeNumber字段值
     * @param id book id
     * @return
     */
    public abstract int getStoreNumber(Integer id);

    /**
     * 根据传入的ShoppingCartItem集合批量修改卖出数量和库存
     * 批量的更新storeNumber和SalesAmount
     * @param items
     */
    public abstract void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items);

}
