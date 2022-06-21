package com.visual.casalinda;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HistoricController implements Initializable {
    @FXML
    private TableColumn nameColumn, codeColumn, qtdColumn, typeColumn, valueColumn, totalColumn, dataColumn;

    @FXML
    private TableView table;

    @FXML
    private DatePicker date1, date2;

    public ArrayList<Movement> movementList;

    private MovementSQL movementSQL = new MovementSQL();

    public void initialize(URL location, ResourceBundle resources) {
        showTable();
        date1.setValue(LocalDate.now());
        date2.setValue(LocalDate.now());
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
        movementList = movementSQL.SearchProduct("SELECT * FROM movement");
        table.setItems(FXCollections.observableArrayList(movementList));
    }

    @FXML
    public void selectDate(){
        String dateInit = date1.toString();
        String dateEnd = date2.toString();
        movementList = movementSQL.SearchProduct("SELECT * FROM movement WHERE data =");
    }

}
