package com.ncl.model;

public class ProvisionItem {

    private String id;
    private String orderby;
    private String date;
    private String amount;
    private String notes;

    public ProvisionItem() {
    }

    public ProvisionItem(String orderby, String date, String amount, String notes) {
        this.orderby = orderby;
        this.date = date;
        this.amount = amount;
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
