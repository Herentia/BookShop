package com.pb.entity;

/**
 * @author haohan
 * 12/11/2018 - 04:02 下午
 */
public class TradeItem {

    private int itemId;
    private int quantity;
    private int tardeId;
    private int bookId;

    public TradeItem() {
    }

    public TradeItem(int itemId, int quantity, int tardeId, int bookId) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.tardeId = tardeId;
        this.bookId = bookId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTardeId() {
        return tardeId;
    }

    public void setTardeId(int tardeId) {
        this.tardeId = tardeId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "TradeItem{" +
                "itemId=" + itemId +
                ", quantity=" + quantity +
                ", tardeId=" + tardeId +
                ", bookId=" + bookId +
                '}';
    }
}
