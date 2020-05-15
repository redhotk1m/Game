package Controllerpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StoryController implements Initializable {

    @FXML
    Canvas storyCanvas;
    @FXML
    Button continueButton;

    private void goToGameScene() {
        continueButton.setOnMouseEntered(event -> {
            SoundController.buttonMouseoverSound.play();
            continueButton.setPadding(new Insets(10, 10, 10, 10));
            continueButton.setFont(Font.font("Rockwell", 40));
        });

        continueButton.setOnMouseExited(event -> {
            SoundController.buttonMouseoverSound.play();
            continueButton.setPadding(new Insets(10, 10, 10, 10));
            continueButton.setFont(Font.font("Rockwell", 36));
        });
    }

    public void inGame(ActionEvent event) throws IOException {
        SoundController.buttonPress.play();
        SoundController.storyBackground.stop();
        SoundController.storyTelling.stop();
        FXMLLoader fxmlLoader = new FXMLLoader();
        System.out.println("Storycontroller: " + getClass().getResource("/resources/Game.fxml"));
        Parent root = fxmlLoader.load(getClass().getResource("/resources/Game.fxml"));
        Scene scene = new Scene(root,900,600);
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        goToGameScene();
    }
}
