package com.visual.casalinda;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TransferesController implements Initializable {

    @FXML
    private TableColumn nameColumn, codeColumn, quantityColumn, descColumn, categoryColumn;

    @FXML
    public TableView table;

    public ArrayList<Product> productList;

    private static Product product;

    private static TransferesController transferesController;
    public void initialize(URL location, ResourceBundle resources) {
        showTable();
        transferesController = this;
    }
    @FXML
    public void showTable() {
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

    public void showtest(String objective){
        String SQL;
        SQL = "SELECT * FROM product WHERE name LIKE '%" + objective + "%'";
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        ProductsSQL productsSQL = new ProductsSQL();
        productList = productsSQL.teste(SQL);
        table.setItems(FXCollections.observableArrayList(productList));
    }

    public void registerTransfer() throws IOException {
        product = (Product) table.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("regTransfer-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 334, 478);
        Stage stage = new Stage();
        stage.setTitle("Registrar transferência");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static Product getProduct() {
        return product;
    }

    public static TransferesController getTransferesController() {
        return transferesController;
    }
}
