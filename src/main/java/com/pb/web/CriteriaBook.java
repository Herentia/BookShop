package com.pb.web;

/**
 * @author haohan
 * 12/11/2018 - 10:57 上午
 * 封装查询条件类
 */
public class CriteriaBook {
    //价格区间的最小值，默认为0
    private int minPrice = 0;
    //价格区间的最大值
    private int maxPrice = Integer.MAX_VALUE;
    //当前页的页码
    private int pageNo;

    public CriteriaBook() {
    }

    public CriteriaBook(int minPrice, int maxPrice, int pageNo) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.pageNo = pageNo;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "CriteriaBook{" +
                "minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", pageNo=" + pageNo +
                '}';
    }
}
