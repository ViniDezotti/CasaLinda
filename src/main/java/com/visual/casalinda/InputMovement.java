package com.visual.casalinda;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InputMovement {

    private String inputMovementCode;
    private String productCode;
    private int quantity;
    private Date date;
    private float inputValue;

    private static List<InputMovement> inputMovementList = new ArrayList<>();

    public InputMovement(String inputMovementCode, String productCode, String quantity, Date date, String inputValue) {

        if ((Float.parseFloat(inputValue) < 0) || (Integer.parseInt(quantity) < 0)) {
            //fazer excessao na classe Menu controller
        }

        for (Product p : Product.productList) {
            if (p.getCode().equals(productCode)) {
                p.setInputPrice(Float.parseFloat(inputValue)); //seta o valor de entrada
                p.setQuantity(Integer.parseInt(quantity)); //adicionar quantidade
            }
        }

        this.inputMovementCode = inputMovementCode;
        this.productCode = productCode;
        this.quantity = Integer.parseInt(quantity);
        this.date = date;
        this.inputValue = Float.parseFloat(inputValue);
        inputMovementList.add(this);
    }

    public String getInputMovementCode() {
        return inputMovementCode;
    }

    public void setInputMovementCode(String inputMovementCode) {
        this.inputMovementCode = inputMovementCode;
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
        if (!(this.quantity - quantity > 0)) {
            //fazer excessao
        }
        this.quantity += quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        if (Float.parseFloat(inputValue) < 0) {
            //fazer excessao

        }
        this.inputValue = Float.parseFloat(inputValue);
    }

    public static List<InputMovement> getInputMovementList() {
        return inputMovementList;
    }

    public static void setInputMovementList(List<InputMovement> inputMovementList) {
        InputMovement.inputMovementList = inputMovementList;
    }
}