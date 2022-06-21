package com.visual.casalinda;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
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

    @FXML
    private ToggleButton inButton, outButton;

    public void initialize(URL location, ResourceBundle resources) {
        showTable();
        //date1.setValue(LocalDate.now());
        //date2.setValue(LocalDate.now());
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
        //movementList = movementSQL.SearchDate(sqlDate1, sqlDate2);
        table.setItems(FXCollections.observableArrayList(movementList));
    }

    @FXML
    public void selectDate(){
        table.setItems(null);
        LocalDate dateInit = date1.getValue();
        if(date2.getValue() == null) date2.setValue(date1.getValue());
        if(date1.getValue() == null) date1.setValue(date2.getValue());
        LocalDate dateEnd = date2.getValue();
        if(dateEnd.isBefore(dateInit))date1.setValue(dateEnd.minusDays(1));
        java.sql.Date sqlDate1 = java.sql.Date.valueOf(dateInit);
        java.sql.Date sqlDate2 = java.sql.Date.valueOf(dateEnd);
        movementList = movementSQL.SearchDate(sqlDate1, sqlDate2);
        table.setItems(FXCollections.observableArrayList(movementList));
    }

    public void selectType(){
        table.setItems(null);
        String type;
        java.sql.Date sqlDate1;
        java.sql.Date sqlDate2;
        if(inButton.isSelected()) type = "compra";
        else type = "venda";
        LocalDate dateInit = date1.getValue();
        if(date2.getValue() == null) date2.setValue(date1.getValue());
        if(date1.getValue() == null) date1.setValue(date2.getValue());
        LocalDate dateEnd = date2.getValue();
        if(dateEnd != null){
            if(dateEnd.isBefore(dateInit))date1.setValue(dateEnd.minusDays(1));
        }

        if((dateInit != null) && (dateEnd != null)) {
            sqlDate1 = java.sql.Date.valueOf(dateInit);
            sqlDate2 = java.sql.Date.valueOf(dateEnd);
        }
        else{
            sqlDate1 = null;
            sqlDate2 = null;
        }
        movementList = movementSQL.searchType(type, sqlDate1, sqlDate2);
        table.setItems(FXCollections.observableArrayList(movementList));
    }
}
