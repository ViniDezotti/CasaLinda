package com.visual.casalinda;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductsController implements Initializable {

    @FXML
    ComboBox itemBox;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("aaa");
        for(int i=0; i<Product.productList.size(); i++){

        }
    }
}
