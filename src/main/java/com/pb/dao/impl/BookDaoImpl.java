package com.pb.dao.impl;

import com.pb.dao.BookDao;
import com.pb.entity.Book;
import com.pb.entity.ShoppingCartItem;
import com.pb.web.CriteriaBook;
import com.pb.web.Page;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author haohan
 * 12/11/2018 - 04:25 下午
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {

    /**
     * 通过ID获取书本信息
     * @param id book的id
     * @return
     */
    @Override
    public Book getBook(int id) {
        String sql = "select id, author, title, price, publishingdate, salesamount, storenumber, remark" +
                " from bs_book where id = ?";
        return query(sql, id);
    }

    @Override
    public Page<Book> getPage(CriteriaBook cb) {
        //获取指定页面的页面数据
        Page<Book> page = new Page<>(cb.getPageNo());
        page.setPageSize(3);
        //设置总记录数
        page.setTotalItemNumber(getTotalBookNumber(cb));
        //效验pageno的合法性
        cb.setPageNo(page.getPageNo());
        //设置页面的数据信息
        page.setList(getPageList(cb, 3));
        return page;
    }

    @Override
    public long getTotalBookNumber(CriteriaBook cb) {
        String sql = "select count(id) from bs_book where price > ? and price < ?";
        BigDecimal totalBookNumber =  getSingleVal(sql, cb.getMinPrice(), cb.getMaxPrice());
        return totalBookNumber.longValue();
    }

    @Override
    public List<Book> getPageList(CriteriaBook cb, int pageSize) {
        String sql = "select * from (select b.*,ROWNUM rn from bs_book b where " +
                "price <= ? and price >= ? and ROWNUM <= ? order by id) " +
                "where rn > ?";
        return queryForList(sql, cb.getMaxPrice(), cb.getMinPrice(),
                pageSize * cb.getPageNo(), (cb.getPageNo() - 1) * pageSize);
    }

    @Override
    public int getStoreNumber(Integer id) {
        String sql = "select storenumber from bs_book where id = ?";
        BigDecimal storenumber = getSingleVal(sql, id);
        return storenumber.intValue();
    }

    @Override
    public void batchUpdateStoreNumberAndSalesAmount(Collection<ShoppingCartItem> items) {
        String sql = "update bs_book set salesAmount = salesAmount + ?, storeNumber = storeNumber - ?" +
                " where id = ?";
        Object [][] params = new Object[items.size()][3];
        List<ShoppingCartItem> lsci = new ArrayList<>(items);
        for(int i = 0; i < lsci.size(); i++) {
            params[i][0] = lsci.get(i).getQuantity();
            params[i][1] = lsci.get(i).getBook().getStoreNumber();
            params[i][2] = lsci.get(i).getBook().getId();
        }
        batch(sql, params);
    }
}
