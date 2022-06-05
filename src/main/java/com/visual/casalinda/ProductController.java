package com.visual.casalinda;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn codeColumn;

    @FXML
    private TableColumn qtdColumn;
    @FXML
    private TableColumn descColumn;
    @FXML
    private TableColumn categoryColumn;

    @FXML
    private TableView table;

    public ArrayList<Product> productList;


    public void initialize(URL location, ResourceBundle resources) {
        showTable();
    }

    @FXML
    public void removeProduct(){
        if(table.getSelectionModel().getSelectedItem() != null) {
            Product productSelected = (Product) table.getSelectionModel().getSelectedItem();
            ProductsSQL productsSQL = new ProductsSQL();
            productsSQL.removeProduct(productSelected);
            showTable();
        }
        else System.out.println("vazio");
    }

    public void showTable(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        qtdColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        ProductsSQL productsSQL = new ProductsSQL();
        productList = productsSQL.SearchProduct();
        System.out.println(productList);
        table.setItems(FXCollections.observableArrayList(productList));
    }

    @FXML
    void addProduct() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("addProduct-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 334, 478);
        Stage stage = new Stage();
        stage.setTitle("Adicionar produto");
        stage.setScene(scene);
        //stage.getIcons().add(Icon);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void editProduct() throws IOException {
        if(table.getSelectionModel().getSelectedItem() != null) {
            Product productSelected = (Product) table.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("editProduct-view"));
            loader.setController(new EditProductController(productSelected));
            Parent root = loader.load();
            Scene scene = new Scene(root, 334, 478);
            Stage stage = new Stage();
            stage.setTitle("Editar produto");
            stage.setScene(scene);
            //stage.getIcons().add(Icon);
            stage.setResizable(false);
            stage.show();
        }
    }

}
