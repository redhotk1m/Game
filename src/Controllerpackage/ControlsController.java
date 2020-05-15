package Controllerpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControlsController implements Initializable{

    @FXML
    Button mainMenu;

    public void goToMenuScene(ActionEvent event) throws IOException {
        Controller.buttonClick();
        SoundController.lowHealth.stop();
        SoundController.youDiedSound.stop();
        SoundController.backgroundMusic.stop();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/Menu.fxml"));
        Scene scene = new Scene(root, 900, 600);
        root.setStyle("-fx-background-image: url('/resources/images/background.png');");
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DropShadow ds = new DropShadow();
        ds.setOffsetY(5.0);
        ds.setOffsetX(5.0);
        ds.setColor(Color.GRAY);
        mainMenu.setEffect(ds);
        mainMenu.setOnMouseEntered(e->{
            SoundController.buttonMouseoverSound.play();
            mainMenu.setOpacity(1);
            mainMenu.setFont(Font.font("Rockwell",33));
            mainMenu.setPadding(new Insets(10,20,10,90));
        });

        mainMenu.setOnMouseExited(e->{
            SoundController.buttonMouseoverSound.stop();
            mainMenu.setOpacity(0.8);
            mainMenu.setFont(Font.font("Rockwell",30));
            mainMenu.setPadding(new Insets(10,80,10,20));

        });
    }
}
