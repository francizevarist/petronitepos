package com.ncl.model;

public class CollectionItem {

    private String id;
    private String pumpname;
    private String opening;
    private String closing;
    private String cash;
    private String credit;
    private String amount;
    private String amountTobeCollected;
    private String amountCollected;
    private String shortExcess;

    public CollectionItem() {
    }

    public CollectionItem(String pumpname, String opening, String closing, String cash, String credit, String amount, String amountTobeCollected, String amountCollected, String shortExcess) {
        this.pumpname = pumpname;
        this.opening = opening;
        this.closing = closing;
        this.cash = cash;
        this.credit = credit;
        this.amount = amount;
        this.amountTobeCollected = amountTobeCollected;
        this.amountCollected = amountCollected;
        this.shortExcess = shortExcess;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPumpname() {
        return pumpname;
    }

    public void setPumpname(String pumpname) {
        this.pumpname = pumpname;
    }

    public String getOpening() {
        return opening;
    }

    public void setOpening(String opening) {
        this.opening = opening;
    }

    public String getClosing() {
        return closing;
    }

    public void setClosing(String closing) {
        this.closing = closing;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmountTobeCollected() {
        return amountTobeCollected;
    }

    public void setAmountTobeCollected(String amountTobeCollected) {
        this.amountTobeCollected = amountTobeCollected;
    }

    public String getAmountCollected() {
        return amountCollected;
    }

    public void setAmountCollected(String amountCollected) {
        this.amountCollected = amountCollected;
    }

    public String getShortExcess() {
        return shortExcess;
    }

    public void setShortExcess(String shortExcess) {
        this.shortExcess = shortExcess;
    }
}
