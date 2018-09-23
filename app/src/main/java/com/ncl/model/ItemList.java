package com.ncl.model;

public class ItemList {

    private String id;
    private String item_name;

    public ItemList() {
    }

    public ItemList(String item_name) {
        this.item_name = item_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
}
