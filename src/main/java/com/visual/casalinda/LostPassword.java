package com.visual.casalinda;

import javax.mail.*
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LostPassword {
    int randomCode;
    @FXML
    private TextField emailField;

    @FXML
    private Button cancelButton;

    @FXML
    private Button searchButton;

    void sendEmail{
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String email = "voxsolutions.staff@gmail.com";
        String password = "pederinho";

        Session session = Session.getInstance(properties, new Authenticator(){
        LostPassword emaikl
        };
    }
}
