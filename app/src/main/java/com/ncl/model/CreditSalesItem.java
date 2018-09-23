package com.ncl.model;

public class CreditSalesItem {

    private String id;
    private String customername;
    private String product;
    private String volume;
    private String pump;
    private String amount;

    public CreditSalesItem() {
    }

    public CreditSalesItem(String customername, String product, String volume, String pump, String amount) {
        this.customername = customername;
        this.product = product;
        this.volume = volume;
        this.pump = pump;
        this.amount = amount;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPump() {
        return pump;
    }

    public void setPump(String pump) {
        this.pump = pump;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
