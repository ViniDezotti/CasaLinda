package com.visual.casalinda;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HistoricController implements Initializable {
    @FXML
    private TableColumn nameColumn, codeColumn, qtdColumn, typeColumn, valueColumn, totalColumn, dataColumn;

    @FXML
    private TableView table;

    public ArrayList<Movement> movementList;

    public void initialize(URL location, ResourceBundle resources) {
        showTable();
    }

    @FXML
    public void showTable() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        qtdColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        MovementSQL movementSQL = new MovementSQL();
        movementList = movementSQL.SearchProduct();
        table.setItems(FXCollections.observableArrayList(movementList));
    }

}
