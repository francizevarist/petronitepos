package com.ncl.model;

public class InventoryItem {

    private String id;
    private String particular;
    private String openingstock;
    private String price;
    private String addstock;
    private String lessstock;
    private String totalamount;
    private String stockbalance;
    private String variance;

    public InventoryItem() {
    }

    public InventoryItem(String particular, String openingstock, String price, String addstock, String lessstock, String totalamount, String stockbalance, String variance) {
        this.particular = particular;
        this.openingstock = openingstock;
        this.price = price;
        this.addstock = addstock;
        this.lessstock = lessstock;
        this.totalamount = totalamount;
        this.stockbalance = stockbalance;
        this.variance = variance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public String getOpeningstock() {
        return openingstock;
    }

    public void setOpeningstock(String openingstock) {
        this.openingstock = openingstock;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddstock() {
        return addstock;
    }

    public void setAddstock(String addstock) {
        this.addstock = addstock;
    }

    public String getLessstock() {
        return lessstock;
    }

    public void setLessstock(String lessstock) {
        this.lessstock = lessstock;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getStockbalance() {
        return stockbalance;
    }

    public void setStockbalance(String stockbalance) {
        this.stockbalance = stockbalance;
    }

    public String getVariance() {
        return variance;
    }

    public void setVariance(String variance) {
        this.variance = variance;
    }
}
