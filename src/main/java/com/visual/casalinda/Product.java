package com.visual.casalinda;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private String name;
    private String code;
    private String description;
    private int quantity;
    private float inputPrice; //valor de entrada do produto
    private float outPrice; // valor de saida
    private String category;

    public static List<Product> productList = new ArrayList<>();

    public Product(String productName, String productCode, String productDescription,
                   String productQuantity, String productCategory) {
        if (!(Integer.parseInt(productQuantity) > 0)) {
            //fazer excessao
        }
        this.name = productName;
        this.code = productCode;
        this.description = productDescription;
        this.quantity = Integer.parseInt(productQuantity);
        this.category = productCategory;
        this.inputPrice = 0;// deixar os dois campos setados como 0 ate que haja uma movimentacao
        this.outPrice = 0;
        productList.add(this);


        for(Product p: productList){
            System.out.println(p.toString());
        }
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

    public void setQuantity(int quantity, int flag) { //abrir janela q n é possivel ter quantidade negativa na segunda tela

        if (flag == 0) {
            this.quantity += quantity;
        } else if (flag == 1) {
            if (!(this.quantity - quantity > 0)) {
                System.out.println("Nao eh possiver ter quantidade negativa");
                //throw new Exception(); ????
            } else this.quantity -= quantity;
        }
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
}