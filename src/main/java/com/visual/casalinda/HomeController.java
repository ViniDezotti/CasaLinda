package com.visual.casalinda;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class HomeController implements Initializable {
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn codeColumn;
    @FXML
    private TableColumn quantityColumn;
    @FXML
    private TableColumn descColumn;
    @FXML
    private TableColumn categoryColumn;

    @FXML
    private TableView table;
    public void initialize(URL location, ResourceBundle resources) {
        showTable();
    }

    public void showTable(){
        ProductsSQL productsSQL = new ProductsSQL();
        ArrayList<Product> productsList = productsSQL.SearchProduct();
        ObservableList<Product> data = (ObservableList<Product>) FXCollections.observableArrayList(productsList);
        for(int i=0; i<productsList.size(); i++){
            //table.getItems().add(data);
            table.setItems(data);
        }
    }
}
