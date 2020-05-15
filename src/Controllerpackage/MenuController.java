package Controllerpackage;

import Model.Character;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class MenuController implements Initializable {

    @FXML
    Label noSaveFileFound;

    @FXML
    Button startButton;

    @FXML
    Button loadButton;

    @FXML
    Button controllerButton;

    @FXML
    Button quitButton;

    private static boolean fileNotFound=false;

    private void noSaveFileTest(){
        Timer timer = new Timer();
        noSaveFileFound.setVisible(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                noSaveFileFound.setVisible(false);
            }
        },1000);
    }

    public void goToStoryScene(ActionEvent event) throws IOException{
        SoundController.storyTelling.setVolume(1);
        SoundController.storyBackground.setVolume(0.7);
        Controller.buttonClick();
        SoundController.introSong.stop();
        SoundController.storyBackground.play();
        SoundController.storyTelling.play();
        System.out.println("MenuController: " + getClass().getResource("/resources/Story.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/resources/Story.fxml"));
        Scene scene2 = new Scene(root,900,600);
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        primaryStage.setScene(scene2);
        primaryStage.show();
    }

    protected void loadPlayerData() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(Controller.fileName));
            Controller.player = (Character)is.readObject();
            Controller.override = false;
            fileNotFound=false;
            is.close();
        } catch (FileNotFoundException e) {
            noSaveFileTest();
            fileNotFound=true;
            System.out.println("Nope");
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("U done goofed");
        }
    }

    public void goToLoadedGameScene(ActionEvent event) throws IOException{
        Controller.buttonClick();
        loadPlayerData();
        if (!fileNotFound) {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/Game.fxml"));
            Scene scene2 = new Scene(root, 900, 600);
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            primaryStage.setScene(scene2);
            primaryStage.show();
        }
    }

    public void quitGame(ActionEvent event) {
        Controller.buttonClick();
        SoundController.exitButtonSound.play();
        Stage stage = (Stage) quitButton.getScene().getWindow();
        stage.close();
        System.out.println("Successfully closed");
    }

    public void goToControlsScene(ActionEvent event) throws IOException{
        Controller.buttonClick();
        SoundController.backgroundMusic.stop();
        SoundController.lowHealth.stop();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root2 = fxmlLoader.load(getClass().getResource("/resources/Controller.fxml"));
        Scene scene22 = new Scene(root2, 900, 600);
        Stage primaryStage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        root2.setStyle("-fx-background-image: url('/resources/images/background.png');");
        primaryStage.setScene(scene22);
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        startButton.setText("Start Game");
        loadButton.setText("Load Game");
        controllerButton.setText("Controls");
        quitButton.setText("Quit Game");
        DropShadow ds = new DropShadow();
        ds.setOffsetY(5.0);
        ds.setOffsetX(5.0);
        ds.setColor(Color.GRAY);
        startButton.setEffect(ds);

       startButton.setOnMouseEntered(e->{
           SoundController.buttonMouseoverSound.play();
            startButton.setOpacity(1);
            startButton.setFont(Font.font("Rockwell", 33));
            startButton.setPadding(new Insets(10, 20, 10, 90));
        });

        startButton.setOnMouseExited(e->{
            SoundController.buttonMouseoverSound.stop();
            startButton.setOpacity(0.8);
            startButton.setFont(Font.font("Rockwell", 30));
            startButton.setPadding(new Insets(10, 80, 10, 20));
        });

        loadButton.setOnMouseEntered(e->{
            SoundController.buttonMouseoverSound.play();
            loadButton.setOpacity(1);
            loadButton.setFont(Font.font("Rockwell", 33));
            loadButton.setPadding(new Insets(10, 20, 10, 90));
        });

        loadButton.setOnMouseExited(e->{
            SoundController.buttonMouseoverSound.stop();
            loadButton.setOpacity(0.8);
            loadButton.setFont(Font.font("Rockwell", 30));
            loadButton.setPadding(new Insets(10, 80, 10, 20));
        });

        controllerButton.setOnMouseEntered(e->{
            SoundController.buttonMouseoverSound.play();
            controllerButton.setOpacity(1);
            controllerButton.setFont(Font.font("Rockwell", 33));
            controllerButton.setPadding(new Insets(10, 20, 10, 90));
        });

        controllerButton.setOnMouseExited(e->{
            SoundController.buttonMouseoverSound.stop();
            controllerButton.setOpacity(0.8);
            controllerButton.setFont(Font.font("Rockwell", 30));
            controllerButton.setPadding(new Insets(10, 80, 10, 20));
        });

        quitButton.setOnMouseEntered(e->{
            SoundController.buttonMouseoverSound.play();
            quitButton.setOpacity(1);
            quitButton.setFont(Font.font("Rockwell", 35));
            quitButton.setPadding(new Insets(10, 20, 10, 90));
        });

        quitButton.setOnMouseExited(e->{
            SoundController.buttonMouseoverSound.play();
            quitButton.setOpacity(0.8);
            quitButton.setFont(Font.font("Rockwell", 30));
            quitButton.setPadding(new Insets(10, 80, 10, 20));
        });
        loadButton.setEffect(ds);
        controllerButton.setEffect(ds);
        quitButton.setEffect(ds);
        startButton.setTextFill(Color.BLACK);
        loadButton.setTextFill(Color.BLACK);
        controllerButton.setTextFill(Color.BLACK);
        quitButton.setTextFill(Color.BLACK);
    }
}
