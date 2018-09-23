package com.ncl.model;

public class AccessoriesItem {

    private String id;
    private String stocksize;
    private String item_name;
    private String item_price;

    public AccessoriesItem() {
    }

    public AccessoriesItem( String stocksize, String item_name, String item_price) {
        this.stocksize = stocksize;
        this.item_name = item_name;
        this.item_price = item_price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStocksize() {
        return stocksize;
    }

    public void setStocksize(String stocksize) {
        this.stocksize = stocksize;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

}
