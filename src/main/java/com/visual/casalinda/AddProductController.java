package com.visual.casalinda;

import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddProductController {
    @FXML
    TextField nameField;

    @FXML
    TextField codField;

    @FXML
    TextArea descArea;

    @FXML
    ComboBox catBox;

    @FXML
    TextField qtdField;

    public void insertProduct() {
        Product product = new Product(nameField.getText(), codField.getText(), descArea.getText(),
                qtdField.getText(), catBox.getSelectionModel().getSelectedItem().toString());

        ProductsSQL productsSQL = new ProductsSQL();
        productsSQL.insertProduct(product);

        nameField.clear();
        codField.clear();
        descArea.clear();
        catBox.getSelectionModel().clearSelection();
        qtdField.clear();
    }
}