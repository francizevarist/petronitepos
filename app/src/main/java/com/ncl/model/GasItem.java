package com.ncl.model;

public class GasItem {

    private String id;
    private String brandname;

    public GasItem() {
    }

    public GasItem(String brandname) {
        this.brandname = brandname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }
}
