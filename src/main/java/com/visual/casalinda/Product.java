package com.visual.casalinda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Product {

    private String name;
    private String code;
    private String description;
    private int quantity;
    private String category;

    public static List<Product> productList = new ArrayList<>();

    public Product(){
    }

    public void addProduct(String productName, String productDescription, int productQuantity, String productCategory){
        this.name = productName;
        this.code = generateCode();
        this.description = productDescription;
        this.quantity = productQuantity;
        this.category = productCategory;
        productList.add(this);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) { //abrir janela q n é possivel ter quantidade negativa na segunda tela
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void addQuantity(int value){
        this.quantity += value;
    }

    public boolean removeQuantity(int value){
        if((this.quantity -= value) >= 0){
            this.quantity -= value;
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                '}';
    }
    public String generateCode() {
        String code;
        Random random = new Random();
        code = String.valueOf(random.nextInt(9999));
        return code;
    }
}