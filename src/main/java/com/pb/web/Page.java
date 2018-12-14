package com.pb.web;

import java.util.List;

/**
 * @author haohan
 * 12/10/2018 - 05:43 下午
 */
public class Page<T> {

    //当前页码
    private int pageNo;

    //本页需要显示的List
    private List<T> list;

    //每页多少条记录
    private int pageSize;

    //总记录数
    private long totalItemNumber;

    //初始化当前页码
    public Page(int pageNo) {
        this.pageNo = pageNo;
    }

    //对当前页码进行效验
    public int getPageNo() {
        if(pageNo <= 0) {
            pageNo = 1;
        }
        if(pageNo > getTotalPageNumber()) {
            pageNo = getTotalPageNumber();
        }
        return pageNo;
    }

    public List<T> getList() {
        return list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    //设置当前页需要显示的List集合
    public void setList(List<T> list) {
        this.list = list;
    }

    //设置总记录数
    public void setTotalItemNumber(long totalItemNumber) {
        this.totalItemNumber = totalItemNumber;
    }

    //获取总页码数
    public int getTotalPageNumber() {
        int totalPageNumber = (int) (totalItemNumber / pageSize);
        if(totalItemNumber % pageSize != 0) {
            totalPageNumber++;
        }
        return totalPageNumber;
    }

    //是否有下一页
    public boolean isHasNext() {
        if(getPageNo() >= getTotalPageNumber())
            return false;
        return true;
    }

    //是否有上一页
    public boolean isHasprev() {
        if(getPageNo() <= 1)
            return false;
        return true;
    }

    //返回上一页
    public int getPrePage() {
        if(isHasprev())
            return getPageNo() - 1;
        return getPageNo();
    }

    //返回下一页
    public int getNextPage() {
        if(isHasNext())
            return getPageNo() + 1;
        return getPageNo();
    }
}
