package com.ncl.model;

public class FuelSalesItem {

    private String id;
    private String pumpname;
    private String shift;
    private String shiftstatus;
    private String amount;
    private String opening;
    private String closing;

    public FuelSalesItem() {
    }

    public FuelSalesItem(String pumpname, String shift, String shiftstatus, String amount, String opening, String closing) {
        this.pumpname = pumpname;
        this.shift = shift;
        this.shiftstatus = shiftstatus;
        this.amount = amount;
        this.opening = opening;
        this.closing = closing;
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

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getShiftstatus() {
        return shiftstatus;
    }

    public void setShiftstatus(String shiftstatus) {
        this.shiftstatus = shiftstatus;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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
}
