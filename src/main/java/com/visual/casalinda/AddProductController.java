package com.visual.casalinda;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddProductController {
    @FXML
    TextField nameField;

    @FXML
    TextArea descArea;

    @FXML
    ComboBox catBox;

    @FXML
    TextField qtdField;

    public void insertProduct() {
        Product product = new Product();
        product.addProduct(nameField.getText(), descArea.getText(), Integer.parseInt(qtdField.getText()), catBox.getSelectionModel().getSelectedItem().toString());
        ProductsSQL productsSQL = new ProductsSQL();
        productsSQL.insertProduct(product);

        nameField.clear();
        descArea.clear();
        catBox.getSelectionModel().clearSelection();
        qtdField.clear();
    }
}