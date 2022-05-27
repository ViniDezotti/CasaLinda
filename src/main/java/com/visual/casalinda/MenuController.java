package com.visual.casalinda;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

   @FXML
    private AnchorPane pane1, pane2;

   @FXML
   private ImageView menu;


   public void initialize(URL location, ResourceBundle resources){
       System.out.println("teste");
       pane1.setVisible(false);
       FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5),pane1);
       fadeTransition.setFromValue(1);
       fadeTransition.setToValue(0);
       fadeTransition.play();

       TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),pane2);
       translateTransition.setByX(-600);
       translateTransition.play();
   }

   public void menuActivate(){
       pane1.setVisible(true);
       FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5), pane1);
       fadeTransition1.setFromValue(0);
       fadeTransition1.setToValue(0.15);
       fadeTransition1.play();

       TranslateTransition translateTransition1=new TranslateTransition(Duration.seconds(0.5), pane2);
       translateTransition1.setByX(+600);
       translateTransition1.play();
   }

   public void menuDeactivate(){
       FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(0.5), pane1);
       fadeTransition1.setFromValue(0.15);
       fadeTransition1.setToValue(0);
       fadeTransition1.play();

       fadeTransition1.setOnFinished(event1 -> {
           pane1.setVisible(false);
       });

       TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), pane2);
       translateTransition1.setByX(-600);
       translateTransition1.play();
   }

}
