package com.visual.casalinda;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

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
    private String Password = "aaa";

    private String User = "admin";

    @FXML
    void changeStyle(String style) {
        passwordField.setId(style);
        userField.setId(style);
        showPasswordField.setId(style);
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
            //Tela logada
            System.out.println("logado"); //Apagar quando finalizar
            return;
        } else warningLabel.setText("Usuário ou senha incorreta.");
        warningLabel.setVisible(true);
        changeStyle("Error");
    }

    boolean checkLogin(String checkPass, String checkUser) {
        warningLabel.setVisible(false);
        if (checkPass.equals(Password) && checkUser.equals(User)) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    void enablePassword() { //Usuario solicita para mostrar senha
        if (passwordField.isVisible()) {
            eyeButton.setId("Button_Eye");
            passwordField.setVisible(false);
            showPasswordField.setText(String.valueOf(passwordField.getText()));
            showPasswordField.setVisible(true);
        }
        else { //Usuario solicita para ocultar senha
            eyeButton.setId("Button_EyeOpen");
            passwordField.setVisible(true);
            passwordField.setText(passwordField.getText());
            showPasswordField.setVisible(false);
        }
    }

    /*@FXML
    void changeScreen(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("fxml/Menu.fxml"));
            stage = (Stage) iniciar.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch(IOException e){
        }
    }*/

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
