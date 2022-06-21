package com.visual.casalinda;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movement {
    private String name;

    private String code;
    private int quantity;

    private String type;

    private float value;

    private float total;
    private java.util.Date date;

    private static List<Movement> movementList = new ArrayList<>();

    public Movement(){

    }

    public void addMovement(Product product, int quantity, String type, LocalDate date, float value) throws IOException {
        this.name = product.getName();
        this.code = product.getCode();
        this.quantity = quantity;
        this.type = type;
        this.date = Date.valueOf(date);
        this.value = value;
        this.total = value * ((float) getQuantity());
        movementList.add(this);
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getTotal() {
        return total;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public java.util.Date getDate() {
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