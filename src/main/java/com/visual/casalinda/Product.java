package com.visual.casalinda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Product {

    private String name;
    private String code;
    private String description;
    private int quantity;
    private float inputPrice; //valor de entrada do produto
    private float outPrice; // valor de saida
    private String category;
    private final Random randomGen = new Random();
    private final StringBuffer stringBuffer = new StringBuffer();

    public static List<Product> productList = new ArrayList<>();

    public Product (String productName, String productDescription, int productQuantity, String productCategory) {
        this.name = productName;
        this.code = String.valueOf(generateCode());
        this.description = productDescription;
        this.quantity = productQuantity;
        this.category = productCategory;
        this.inputPrice = 0;
        this.outPrice = 0;
        productList.add(this);

        for(Product p: productList){
            System.out.println(p.toString());
        }
    }

    public addProduct() {

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

    public float getInputPrice() {
        return inputPrice;
    }

    public void setInputPrice(float inputPrice) {
        if (!(inputPrice > 0)) {
            //fazer excessao
        } else this.inputPrice = inputPrice;
    }

    public float getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(float outPrice) {
        this.outPrice = outPrice;
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
    public StringBuffer generateCode() {
        for (int i = 0; i < 4; i++) {
            int nextRandomChar = 65
                    + (int) (randomGen.nextFloat()
                    * (90 - 65 + 1));
            stringBuffer.append((char) nextRandomChar);
        }
        stringBuffer.append(randomGen.nextInt(9));
        return stringBuffer;
    }
}