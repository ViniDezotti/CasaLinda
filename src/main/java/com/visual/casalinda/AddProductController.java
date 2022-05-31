package com.visual.casalinda;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class AddProductController {
    @FXML
    TextField nameField;

    @FXML
    TextField codField;

    @FXML
    TextArea descArea;

    @FXML
    ComboBox catBox;

    @FXML
    TextField qtdField;

    public void insertProduct() {
        new Product(nameField.getText(), codField.getText(), descArea.getText(),
                qtdField.getText(), catBox.getSelectionModel().getSelectedItem().toString());

        nameField.clear();
        codField.clear();
        descArea.clear();
        catBox.getSelectionModel().clearSelection();
        qtdField.clear();
    }
}
