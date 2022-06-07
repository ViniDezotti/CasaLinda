package com.visual.casalinda;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movement {
    private Product product;
    private int quantity;

    private String type;

    private float value;
    private Date date;

    private static List<Movement> movementList = new ArrayList<>();

    public Movement(){

    }

    public void addMovement(Product product, int quantity, String type, Date date, float value) throws IOException {
        this.product = product;
        this.quantity = quantity;
        this.type = type;
        this.date = date;
        this.value = value;
        movementList.add(this);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public static List<Movement> getMovementList() {
        return movementList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}