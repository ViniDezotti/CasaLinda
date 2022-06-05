package com.visual.casalinda;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
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
    public TableView table;

    public ArrayList<Product> productList;

    public void initialize(URL location, ResourceBundle resources) {
        showTable();
    }

    public void showTable(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        ProductsSQL productsSQL = new ProductsSQL();
        productList = productsSQL.SearchProduct();
        System.out.println(productList);
        table.setItems(FXCollections.observableArrayList(productList));
    }
}
