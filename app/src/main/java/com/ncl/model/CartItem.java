package com.ncl.model;

public class CartItem {

    private String id;
    private String name;
    private String price;
    private String quantity;
    private String totalamount;
    private String discount;

    public CartItem() {
    }

    public CartItem(String name, String price, String quantity, String totalamount, String discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalamount = totalamount;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

}
