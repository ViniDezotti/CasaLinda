package com.visual.casalinda;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Objects;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private AnchorPane pane1, pane2;

    @FXML
    private ToggleButton Menu;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private StackPane contentArea;

    @FXML
    private TextField searchField;

    @FXML
    private ImageView searchButton;

    public void initialize(URL location, ResourceBundle resources) {
        pane1.setVisible(false);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.5), pane2);
        translateTransition.setByX(-600);
        translateTransition.play();

        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("home-view.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void menuActivate() {
        if (pane1.isVisible()) {
            Menu.setDisable(true);
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), pane1);
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                pane1.setVisible(false);
                Menu.setDisable(false);
            });

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), pane2);
            translateTransition1.setByX(-600);
            translateTransition1.play();

            RotateTransition rt = new RotateTransition(Duration.seconds(0.5), Menu);
            rt.setByAngle(-90);
            rt.play();
        } else {
            pane1.setVisible(true);
            Menu.setDisable(true);
            FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), pane1);
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();
            fadeTransition1.setOnFinished(event1 -> {
                Menu.setDisable(false);
            });

            TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), pane2);
            translateTransition1.setByX(+600);
            translateTransition1.play();

            RotateTransition rt = new RotateTransition(Duration.seconds(0.5), Menu);
            rt.setByAngle(90);
            rt.play();
        }
    }

    public void home() {
        try {
            searchField.setVisible(true);
            searchButton.setVisible(true);
            Parent fxml = FXMLLoader.load(getClass().getResource("home-view.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void products(){
        try {
            searchField.setVisible(true);
            searchButton.setVisible(true);
            Parent fxml = FXMLLoader.load(getClass().getResource("product-view.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void transations() {
        try {
            searchField.setVisible(false);
            searchButton.setVisible(false);
            Parent fxml = FXMLLoader.load(getClass().getResource("transfers-view.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void historic() {
        try {
            searchField.setVisible(false);
            searchButton.setVisible(false);
            Parent fxml = FXMLLoader.load(getClass().getResource("historic-view.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void logout() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
            stage = (Stage) Menu.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
