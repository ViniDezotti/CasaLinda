package com.visual.casalinda;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
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

    @FXML
    private ToggleButton prodButton, catButton;

    @FXML
    private Label valueLabel, profitLabel, sellsLabel;
    public ArrayList<Product> productList;

    public static HomeController homeController;

    public void initialize(URL location, ResourceBundle resources) {
        showTable();
        showValues();
        homeController = this;
    }

    public void showTable(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        ProductsSQL productsSQL = new ProductsSQL();
        productList = productsSQL.SearchProduct();
        table.setItems(FXCollections.observableArrayList(productList));
    }

    public void showValues(){
        MovementSQL movementSQL = new MovementSQL();
        sellsLabel.setText(String.valueOf(movementSQL.transfersDay()));
        profitLabel.setText(String.valueOf("R$" + movementSQL.profitDay()));
        valueLabel.setText(String.valueOf("R$" + movementSQL.valueDay()));
    }

    public static HomeController getHomeController() {
        return homeController;
    }

    public void showtest(String objective){
        String SQL;
        if(prodButton.isSelected()) SQL = "SELECT * FROM product WHERE name LIKE '%" + objective + "%'";
        else SQL = "SELECT * FROM product WHERE category LIKE '%" + objective + "%'";
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        ProductsSQL productsSQL = new ProductsSQL();
        productList = productsSQL.teste(SQL);
        table.setItems(FXCollections.observableArrayList(productList));
    }
}
