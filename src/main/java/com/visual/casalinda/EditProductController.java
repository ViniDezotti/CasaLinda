package com.visual.casalinda;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class EditProductController implements Initializable {

    @FXML
    private TextField nameField, qtdField, codeField;

    @FXML
    private ComboBox catBox;

    @FXML
    private TextArea descArea;

    public EditProductController(Product product) {
        nameField.setText(product.getName());
        qtdField.setText(String.valueOf(product.getQuantity()));
        codeField.setText(product.getCode());
        for(int i=0; i<catBox.getItems().size(); i++) {
            if(catBox.getItems().get(i).equals(product.getCategory()))
                catBox.setSelectionModel((SingleSelectionModel) catBox.getItems().get(i));
        }
        descArea.setText(product.getDescription());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
