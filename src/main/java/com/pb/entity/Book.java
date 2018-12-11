package com.pb.entity;

import java.util.Date;

/**
 * @author haohan
 * 12/11/2018 - 04:05 下午
 */
public class Book {

    private int id;
    private String author;
    private String title;
    private double price;
    private Date publishingDate;
    private int salesAmount;
    private int storeNumber;
    private String remark;

    public Book() {
    }

    public Book(int id, String author, String title, double price, Date publishingDate, int salesAmount, int storeNumber, String remark) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
        this.publishingDate = publishingDate;
        this.salesAmount = salesAmount;
        this.storeNumber = storeNumber;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public int getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(int salesAmount) {
        this.salesAmount = salesAmount;
    }

    public int getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(int storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", publishingDate=" + publishingDate +
                ", salesAmount=" + salesAmount +
                ", storeNumber=" + storeNumber +
                ", remark='" + remark + '\'' +
                '}';
    }
}
