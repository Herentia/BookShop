package com.pb.dao.impl;

import com.pb.dao.BookDao;
import com.pb.entity.Book;
import com.pb.web.CriteriaBook;
import com.pb.web.Page;

import java.util.List;

/**
 * @author haohan
 * 12/11/2018 - 04:25 下午
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {

    @Override
    public Book getBook(int id) {
        String sql = "select id, author, title, publishingdate, salesamount, storenumber, remark" +
                " from bs_book where id = ?";
        return query(sql, id);
    }

    @Override
    public Page<Book> getPage(CriteriaBook cb) {
        return null;
    }

    @Override
    public long getTotalBookNumber(CriteriaBook cb) {
        return 0;
    }

    @Override
    public List<Book> getPageList(CriteriaBook cb, int pageSize) {
        return null;
    }

    @Override
    public int getStoreNumber(Integer id) {
        return 0;
    }
}
