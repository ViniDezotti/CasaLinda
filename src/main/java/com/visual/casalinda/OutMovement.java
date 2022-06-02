package com.visual.casalinda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutMovement {

    private String outMovementCode;
    private String productCode;
    private int quantity;
    private Date date;
    private float outValue; //valor que foi vendido

    public static List<OutMovement> outMovementsList = new ArrayList<>();

    public OutMovement(String outMovementCode, String productCode, String quantity, Date date, String outValue) {
        if ((Float.parseFloat(outValue) < 0) || (Integer.parseInt(quantity) < 0)) {
            //fazer excesssao
        }
        for (Product p : Product.productList) {
            if (p.getCode().equals(productCode)) {
                p.setOutPrice(Float.parseFloat(outValue));
                p.setQuantity(Integer.parseInt(quantity));
            }
        }
        this.outMovementCode = outMovementCode;
        this.productCode = productCode;
        this.quantity = Integer.parseInt(quantity);
        this.date = date;
        this.outValue = Float.parseFloat(outValue);
        outMovementsList.add(this);
    }

    public String getOutMovementCode() {
        return outMovementCode;
    }

    public void setOutMovementCode(String outMovementCode) {
        this.outMovementCode = outMovementCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getOutValue() {
        return outValue;
    }

    public void setOutValue(float outValue) {
        this.outValue = outValue;
    }

}