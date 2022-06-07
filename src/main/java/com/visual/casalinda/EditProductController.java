package com.visual.casalinda;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProductController implements Initializable {

    @FXML
    private TextField nameField, qtdField, codeField;

    @FXML
    private ComboBox catBox;

    @FXML
    private TextArea descArea;

    private Product product;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        product = ProductController.getProduct();
        nameField.setText(product.getName());
        qtdField.setText(String.valueOf(product.getQuantity()));
        codeField.setText(product.getCode());
        descArea.setText(product.getDescription());
        for(int i=0; i< catBox.getItems().size(); i++){
            if(catBox.getItems().get(i).equals(product.getCategory()))
                catBox.getSelectionModel().select(i);
        }
    }

    public void saveEdits(){
        product.setName(nameField.getText());
        product.setCode(codeField.getText());
        product.setQuantity(Integer.parseInt(qtdField.getText()));
        product.setCategory(catBox.getSelectionModel().getSelectedItem().toString());
        product.setDescription(descArea.getText());

        ProductsSQL productsSQL = new ProductsSQL();
        productsSQL.editProduct(product);

        ProductController.getProductController().showTable();
        Stage stage = (Stage) catBox.getScene().getWindow();
        stage.close();
    }

}
