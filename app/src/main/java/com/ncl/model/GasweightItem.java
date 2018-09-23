package com.ncl.model;

public class GasweightItem {

    private String id;
    private String weight;
    private String pricerefill;
    private String pricenew;

    public GasweightItem() {
    }

    public GasweightItem(String weight, String pricerefill, String pricenew) {
        this.weight = weight;
        this.pricerefill = pricerefill;
        this.pricenew = pricenew;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPricerefill() {
        return pricerefill;
    }

    public void setPricerefill(String pricerefill) {
        this.pricerefill = pricerefill;
    }

    public String getPricenew() {
        return pricenew;
    }

    public void setPricenew(String pricenew) {
        this.pricenew = pricenew;
    }
}
