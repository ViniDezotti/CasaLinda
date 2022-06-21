package com.visual.casalinda;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class RegTransferController implements Initializable {

    @FXML
    private TextField nameField, codeField, qtdField, valueField;
    @FXML
    private ToggleButton buyButton, sellButton;

    @FXML
    private DatePicker date;

    private Product product;


    public void initialize(URL location, ResourceBundle resources) {
        product = TransferesController.getProduct();
        nameField.setText(product.getName());
        codeField.setText(product.getCode());
        date.setValue(LocalDate.now());
    }

    public void transference() throws IOException {
        String type;
        if(buyButton.isSelected()){
            type = "compra";
            product.addQuantity(Integer.valueOf(qtdField.getText()));
            ProductsSQL productsSQL = new ProductsSQL();
            productsSQL.editProduct(product);
        }
        else{
            type = "venda";
            if(product.removeQuantity(Integer.valueOf(qtdField.getText()))){
                ProductsSQL productsSQL = new ProductsSQL();
                productsSQL.editProduct(product);
            }
            else new Alert(Alert.AlertType.ERROR);
        };

        LocalDate data = date.getValue();
        Movement movement = new Movement();
        movement.addMovement(product, Integer.valueOf(qtdField.getText()), type, data, Float.valueOf(valueField.getText()));
        MovementSQL movementSQL = new MovementSQL();
        movementSQL.registration(movement);

        TransferesController.getTransferesController().showTable();
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close();
    }
}
