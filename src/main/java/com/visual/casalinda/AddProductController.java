package com.visual.casalinda;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

        ProductController.getProductController().showTable();
        Stage stage = (Stage) catBox.getScene().getWindow();
        stage.close();
    }
}