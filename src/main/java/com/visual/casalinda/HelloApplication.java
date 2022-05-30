package com.visual.casalinda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login-view.fxml"));
        Image Icon = new Image(Objects.requireNonNull(HelloApplication.class.getResourceAsStream("images/icon.png")));
        Scene scene = new Scene(fxmlLoader.load(), 720, 480);
        stage.setTitle("Casa Linda");
        stage.setScene(scene);
        stage.getIcons().add(Icon);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}