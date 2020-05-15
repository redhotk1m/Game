package Controllerpackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import static Controllerpackage.SoundController.exitButtonSound;
import static Controllerpackage.SoundController.introSong;
import static Controllerpackage.SoundController.*;

public class ApplicationStarter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root1 = FXMLLoader.load(getClass().getResource("/resources/Menu.fxml"));
        primaryStage.setTitle("The adventures of Henrik");
        primaryStage.setScene(new Scene(root1, 900, 600));
        introSong.setCycleCount(AudioClip.INDEFINITE);
        introSong.play(0.2);
        primaryStage.show();
        root1.setStyle("-fx-background-image: url('/resources/images/background.png');");
        primaryStage.setOnCloseRequest(event -> {
            primaryStage.close();
            closeProgram();
        });
    }

    public void launchApplication(String[] args) {
        launch(args);
    }



    private void closeProgram(){
        exitButtonSound.play();
        backgroundMusic.stop();
        introSong.stop();
        System.out.println("Successfully closed");
    }
}

