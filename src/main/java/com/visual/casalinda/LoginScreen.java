package com.visual.casalinda;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginScreen {
    @FXML
    private ImageView eyeButton;

    @FXML
    private TextField userField;

    @FXML
    private TextField showPasswordField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label warningLabel;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    private String Password = "aaa";

    private String User = "admin";

    @FXML
    void changeStyle(String style) {
        passwordField.setId(style);
        userField.setId(style);
        showPasswordField.setId(style);
    }

    @FXML
    public void afterLogin() {
        try{
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu-view.fxml")));
            stage = (Stage) userField.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void checkFields() {
        String checkUser = userField.getText();
        String checkPass;

        if (passwordField.isVisible()) checkPass = String.valueOf(passwordField.getText());
        else checkPass = showPasswordField.getText();

        changeStyle("Default");

        if (checkUser.isEmpty() || checkPass.isEmpty()) {
            warningLabel.setText("Preencha os campos vazios.");
            changeStyle("Error");
        } else if (checkLogin(checkPass, checkUser)) {
            afterLogin();
            System.out.println("logado"); //Apagar quando finalizar
            return;
        } else warningLabel.setText("Usuário ou senha incorreta.");
        warningLabel.setVisible(true);
        changeStyle("Error");
    }

    boolean checkLogin(String checkPass, String checkUser) {
        warningLabel.setVisible(false);
        return checkPass.equals(Password) && checkUser.equals(User);
    }

    @FXML
    void enablePassword() { //Usuario solicita para mostrar senha
        if (passwordField.isVisible()) {
            System.out.println("mostrar");
            //eyeButton.setId("eyeButton");
            eyeButton.setId("eyeOpenButton");
            passwordField.setVisible(false);
            showPasswordField.setText(String.valueOf(passwordField.getText()));
            showPasswordField.setVisible(true);
        } else { //Usuario solicita para ocultar senha
            System.out.println("ocultar");
            //eyeButton.setId("eyeOpenButton");
            eyeButton.setId("eyeButton");
            passwordField.setVisible(true);
            passwordField.setText(passwordField.getText());
            showPasswordField.setVisible(false);
        }
    }

    @FXML
    void forgotPassowrd() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("lostPassword-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 470, 600);
        Stage stage = new Stage();
        stage.setTitle("Esqueceu Senha");
        stage.setScene(scene);
        //stage.getIcons().add(Icon);
        stage.setResizable(false);
        stage.show();
    }
}
