package com.visual.casalinda;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.stage.Stage;

public class ProductController implements Initializable {
    @FXML
    ComboBox itemBox;

    public void initialize(URL location, ResourceBundle resources) {

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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("editProduct-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 334, 478);
        Stage stage = new Stage();
        stage.setTitle("Editar produto");
        stage.setScene(scene);
        //stage.getIcons().add(Icon);
        stage.setResizable(false);
        stage.show();
    }

}
