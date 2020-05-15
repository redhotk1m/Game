package Controllerpackage;

import Model.*;
import Model.Character;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import static Model.ImportantValues.*;
import static Model.Character.*;
import static view.GameCamera.*;

public class Controller implements Initializable {

    public static ArrayList<SpriteAnimation> enemyAnimationList = new ArrayList<>();
    public static ArrayList<ImageView> enemiesImageView = new ArrayList<>();
    public static ArrayList<ImageView> coinsImageView = new ArrayList<>();
    public static ArrayList<Coin> coins = new ArrayList<>();
    public static ArrayList<ImageView> healthPackImageView = new ArrayList<>();
    public static ArrayList<Healthpack> healthpacks = new ArrayList<>();
    public static ArrayList<Enemy> enemies = new ArrayList<>();
    private Boolean upPressed = new Boolean(false);
    private Boolean downPressed = new Boolean(false);
    private Boolean leftPressed = new Boolean(false);
    private Boolean rightPressed = new Boolean(false);
    private boolean escapePressed = new Boolean(false);
    private boolean isPaused = new Boolean(false);
    private boolean attackPause = new Boolean(false);
    private boolean spacePressed = new Boolean(false);
    private Boolean attackPauseReverse = new Boolean(false);
    private Boolean shiftPressed = new Boolean(false);
    private boolean enemyDamaged = false;
    private static boolean damagePlayerPause;
    public static Rectangle attackRect = new Rectangle(300, 300);
    public static String fileName = "data.bin";
    private boolean stopLowHealth = false;
    public static boolean override = true;
    private int yMove;
    private int xMove;
    private int arrayCreation = 0;
    public static int lastKnownDirection = 0;
    static int lastKnownDirection2 = 0;
    MotionBlur b = new MotionBlur();
    private Enemy removeEnemy = null;
    private Coin removeCoin = null;
    private SpriteAnimation removeEnemyAnimation = null;
    private Healthpack removeHealthpack = null;
    private ImageView removeEnemyImageView = null;
    private ImageView removeCoinImageView = null;
    private ImageView removeHealthpackImageView = null;
    private EnemySpawn enemySpawn;
    private EnemyMovement enemyMove;
    private MapCreation mapCreator;
    private SpriteAnimation animation;
    public static SpriteAnimation enemyAnimation;
    public static SpriteAnimation enemyAni;
    public static Enemy enemy;
    private static Coin coin;
    private static Healthpack healthpack;
    public static Character player;
    private static ImageView playerImage;
    private static ImageView coinImage;
    private static ImageView healthpackImage;
    private static Rectangle playerRect;
    private double staminaValue;
    private double sprintSpeed = 0;
    private double opacityValue;
    private double actualHealth2;
    private double pauseBackround = -520;
    private double pauseTopPanel = 0;
    FadeTransition ftLowHealth;
    FadeTransition ftBoxTop;
    GraphicsContext gc;
    GraphicsContext gc2;
    GraphicsContext gc3;
    @FXML
    Button quitNoSave;
    @FXML
    Button quitAndSave;
    @FXML
    AnchorPane victoryScreen;
    @FXML
    Label upgradeCostLabel;
    @FXML
    Label saveConfirmation;
    @FXML
    Label healthPluss2Label;
    @FXML
    Label healthRegenPlussLabel;
    @FXML
    Label staminaPluss2Label;
    @FXML
    Label staminaRegenPlussLabel;
    @FXML
    Label speedPlussLabel;
    @FXML
    Label damagePlussLabel;
    @FXML
    Button damagePluss;
    @FXML
    Button speedPluss;
    @FXML
    Button staminaRegenPluss;
    @FXML
    Button staminaPluss2;
    @FXML
    Button healthRegenPluss;
    @FXML
    Button healthPluss2;
    @FXML
    HBox boxStats;
    @FXML
    ImageView boxTop;
    @FXML
    ImageView boxMenu;
    @FXML
    AnchorPane topPanel;
    @FXML
    Rectangle blackScreenPaused;
    @FXML
    Button backToMenuPaused;
    @FXML
    Button quitGamePaused;
    @FXML
    Button resumeGamePaused;
    @FXML
    VBox menuPaused;
    @FXML
    AnchorPane characterPane;
    @FXML
    Rectangle blackScreen;
    @FXML
    Button saveButton;
    @FXML
    Label youDied;
    @FXML
    Rectangle visibleHealthbar;
    @FXML
    Rectangle backgroundHealthbar;
    @FXML
    Label labelCoin;
    @FXML
    public Canvas backgroundCanvas;
    @FXML
    Rectangle backgroundHealthbarRed;
    @FXML
    AnchorPane pane;
    @FXML
    AnchorPane drawPane;
    @FXML
    Button backToMenu;
    @FXML
    Label pauseLabel;
    @FXML
    Rectangle backgroundStaminabar;
    @FXML
    Rectangle visibleStaminabar;
    @FXML
    Button healthPluss;
    @FXML
    Button staminaPluss;
    @FXML
    Canvas layerZero;
    @FXML
    Canvas layerTop;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cleanArray();
        clear();
        enemySpawn = new EnemySpawn();
        gc = backgroundCanvas.getGraphicsContext2D();
        gc2 = layerZero.getGraphicsContext2D();
        gc3 = layerTop.getGraphicsContext2D();
        mapCreator = new MapCreation(gc, gc3, drawPane);
        mapCreator.setEnemyView(enemiesImageView);
        if (override) {
            player = new Character(450, 300, 0, 30, 30, 1, 0, 1, 0, 30, 3, 1);
        }
        override = true;
        try {
            mapCreator.manager();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        enemyMove = new EnemyMovement();
        enemyMove.setEnemyArrays(enemiesImageView, enemyAnimationList);
        attackRect.setOpacity(0);
        characterPane.getChildren().add(attackRect);
        Image imageCharacterPNG = new Image("/resources/images/Test_Glow.png");
        playerImage = new ImageView(imageCharacterPNG);
        playerRect = new Rectangle(player.getPlayerX(), player.getPlayerY(), 20, 32);
        ftLowHealth = new FadeTransition(Duration.seconds(1), visibleHealthbar);
        ftBoxTop = new FadeTransition(Duration.seconds(0.3), boxTop);
        SoundController.introSong.stop();
        SoundController.storyBackground.setCycleCount(AudioClip.INDEFINITE);
        SoundController.bossMusic.setCycleCount(AudioClip.INDEFINITE);
        SoundController.backgroundMusic.setCycleCount(AudioClip.INDEFINITE);
        SoundController.backgroundMusic.play(0.5);
        labelCoin.setEffect(null);
        resumeGamePaused.setPadding(new Insets(10, 70, 10, 20));
        saveButton.setPadding(new Insets(10, 140, 10, 20));
        backToMenuPaused.setPadding(new Insets(10, 110, 10, 20));
        quitGamePaused.setPadding(new Insets(10, 140, 10, 20));

        quitNoSave.setOnMouseEntered(e -> {
            SoundController.buttonMouseoverSound.play(1);
            quitNoSave.setFont(Font.font("Rockwell", 26));
        });

        quitNoSave.setOnMouseExited(e -> {
            SoundController.buttonMouseoverSound.stop();
            quitNoSave.setFont(Font.font("Rockwell", 20));
        });

        quitAndSave.setOnMouseEntered(e -> {
            SoundController.buttonMouseoverSound.play(1);
            quitAndSave.setFont(Font.font("Rockwell", 26));
        });

        quitAndSave.setOnMouseExited(e -> {
            SoundController.buttonMouseoverSound.stop();
            quitAndSave.setFont(Font.font("Rockwell", 20));
        });

        resumeGamePaused.setOnMouseEntered(e -> {
            SoundController.buttonMouseoverSound.play(1);
            resumeGamePaused.setPadding(new Insets(10, 20, 10, 50));
            resumeGamePaused.setOpacity(1);
            resumeGamePaused.setFont(Font.font(28));
        });

        resumeGamePaused.setOnMouseExited(e -> {
            SoundController.buttonMouseoverSound.stop();
            resumeGamePaused.setPadding(new Insets(10, 70, 10, 20));
            resumeGamePaused.setOpacity(0.8);
            resumeGamePaused.setFont(Font.font("Rockwell", 24));
        });

        saveButton.setOnMouseEntered(e -> {
            SoundController.buttonMouseoverSound.play(1);
            saveButton.setPadding(new Insets(10, 20, 10, 55));
            saveButton.setOpacity(1);
            saveButton.setFont(Font.font(28));
        });

        saveButton.setOnMouseExited(e -> {
            SoundController.buttonMouseoverSound.stop();
            saveButton.setPadding(new Insets(10, 140, 10, 20));
            saveButton.setOpacity(0.8);
            saveButton.setFont(Font.font("Rockwell", 24));
        });

        backToMenu.setOnMouseEntered(event -> {
            SoundController.buttonMouseoverSound.play(1);
            backToMenu.setPadding(new Insets(10, 10, 10, 10));
            backToMenu.setFont(Font.font("Rockwell", 32));
        });

        backToMenu.setOnMouseExited(event -> {
            SoundController.buttonMouseoverSound.stop();
            backToMenu.setPadding(new Insets(10, 10, 10, 10));
            backToMenu.setFont(Font.font("Rockwell", 28));
        });

        backToMenuPaused.setOnMouseEntered(e -> {
            SoundController.buttonMouseoverSound.play(1);
            backToMenuPaused.setPadding(new Insets(10, 20, 10, 55));
            backToMenuPaused.setOpacity(1);
            backToMenuPaused.setFont(Font.font(28));
        });

        backToMenuPaused.setOnMouseExited(e -> {
            SoundController.buttonMouseoverSound.stop();
            backToMenuPaused.setPadding(new Insets(10, 110, 10, 20));
            backToMenuPaused.setOpacity(0.8);
            backToMenuPaused.setFont(Font.font("Rockwell", 24));
        });

        quitGamePaused.setOnMouseEntered(e -> {
            SoundController.buttonMouseoverSound.play(1);
            quitGamePaused.setPadding(new Insets(10, 20, 10, 55));
            quitGamePaused.setOpacity(1);
            quitGamePaused.setFont(Font.font(28));
        });

        quitGamePaused.setOnMouseExited(e -> {
            SoundController.buttonMouseoverSound.stop();
            quitGamePaused.setPadding(new Insets(10, 140, 10, 20));
            quitGamePaused.setOpacity(0.8);
            quitGamePaused.setFont(Font.font("Rockwell", 24));
        });
        backToMenu.setVisible(false);
        playerImage.setViewport(new Rectangle2D(player.offsetX, player.offsetY, player.width, player.height));
        animation = new SpriteAnimation(playerImage, Duration.millis(400), player.count, player.columns, player.offsetX, player.offsetY, player.width, player.height);
        characterPane.getChildren().add(playerImage);
        playerImage.setX(player.playerX - getCamX());
        playerImage.setY(player.playerY - getCamY());
        playerImage.setFocusTraversable(true);

        playerImage.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {
                    upPressed = true;
                }
                if (event.getCode() == KeyCode.DOWN) {
                    downPressed = true;
                }
                if (event.getCode() == KeyCode.LEFT) {
                    leftPressed = true;
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    rightPressed = true;
                }
                if (event.getCode() == KeyCode.ESCAPE) {
                    escapePressed = true;
                    pauseGame();
                }
                if (event.getCode() == KeyCode.SPACE) {
                    spacePressed = true;
                }
                if ((event.isShiftDown() && (staminaValue >= 10)) && !attackPauseReverse) {
                    shiftPressed = true;
                    sprintSpeed = player.getPlayerSpeedModifier();
                }
            }
        });
        playerImage.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.UP) {
                    upPressed = false;
                }
                if (event.getCode() == KeyCode.DOWN) {
                    downPressed = false;
                }
                if (event.getCode() == KeyCode.LEFT) {
                    leftPressed = false;
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    rightPressed = false;
                }
                if (event.getCode() == KeyCode.ESCAPE) {
                    escapePressed = false;
                }
                if (event.getCode() == KeyCode.SPACE) {
                    spacePressed = false;
                }
                if (!event.isShiftDown()) {
                    shiftPressed = false;
                    sprintSpeed = 1;
                    pane.setEffect(null);
                }
            }
        });
        timer.start();
        switch (player.getGameState()) {
            case 0:
                mapCreator.setMapAndPlayer(32, 22, 1024, 704, player.getPlayerX(), player.getPlayerY());
                mapCreator.changeMap = true;
                break;
            case 1:
                mapCreator.setMapAndPlayer(32, 22, 1024, 704, player.getPlayerX(), player.getPlayerY());
                mapCreator.changeMap = true;
                break;
            case 2:
                mapCreator.setMapAndPlayer(70, 22, 2240, 704, player.getPlayerX(), player.getPlayerY());
                mapCreator.changeMap = true;
                break;
            case 3:
                mapCreator.setMapAndPlayer(32, 22, 1024, 704, player.getPlayerX(), player.getPlayerY());
                mapCreator.changeMap = true;
                break;
            case 4:
                mapCreator.setMapAndPlayer(32, 32, 1024, 1024, player.getPlayerX(), player.getPlayerY());
                mapCreator.changeMap = true;
                break;
            case 5:
                mapCreator.setMapAndPlayer(29, 19, 928, 608, player.getPlayerX(), player.getPlayerY());
                mapCreator.changeMap = true;
                break;
            case 6:
                mapCreator.setMapAndPlayer(32, 22, 1024, 704, player.getPlayerX(), player.getPlayerY());
                mapCreator.changeMap = true;
                break;
            case 7:
                mapCreator.setMapAndPlayer(32, 22, 1024, 704, player.getPlayerX(), player.getPlayerY());
                mapCreator.changeMap = true;
                break;
        }
    }

    private void clearGraphics() {
        gc.clearRect(0, 0, getWorldSizeX(), getWorldSizeY());
        gc2.clearRect(0, 0, getWorldSizeX(), getWorldSizeY());
        gc3.clearRect(0, 0, getWorldSizeX(), getWorldSizeY());
    }

    public void menuChangeScene(ActionEvent event) throws IOException {
        buttonClick();
        SoundController.lowHealth.stop();
        SoundController.youDiedSound.stop();
        SoundController.bossMusic.stop();
        SoundController.backgroundMusic.stop();
        timer.stop();
        Parent root = FXMLLoader.load(getClass().getResource("/resources/Menu.fxml"));
        Scene scene = new Scene(root, 900, 600);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        root.setStyle("-fx-background-image: url('/resources/images/background.png');");
        primaryStage.setScene(scene);
        SoundController.introSong.play(0.5);
        primaryStage.show();
    }

    public void savePlayerData() {
        Timer saveTimer = new Timer();
        saveTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                saveConfirmation.setVisible(false);
            }
        }, 1000);
        saveConfirmation.setVisible(true);
        buttonClick();
        SoundController.savedGameSound.play(1);
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(player);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            playerRect.setX(player.getPlayerX() - getCamX() + 6);
            playerRect.setY(player.getPlayerY() - getCamY());
            gameCameraUpdate();
            backgroundCanvas.setTranslateX(-getCamX());
            backgroundCanvas.setTranslateY(-getCamY());
            layerZero.setTranslateX(-getCamX());
            layerZero.setTranslateY(-getCamY());
            layerTop.setTranslateX(-getCamX());
            layerTop.setTranslateY(-getCamY());
            try {
                mapCreator.drawMap();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            update();
            if (mapCreator.changeMap) {
                clearNewLevel();
                mapCreator.changeMap = false;
            }
            if (arrayCreation < 1) {
                if (player.getGameState() == 5) {
                    SoundController.bossMusic.stop();
                    SoundController.backgroundMusic.stop();
                    SoundController.bossMusic.play(0.5);
                }
                arrayCreation++;
                try {
                    mapCreator.manager();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    private void clearNewLevel() {
        cleanArray();
        mapCreator.clearAllFXElements();
        clearGraphics();
    }

    private void cleanArray() {
        enemyAnimationList.clear();
        coinsImageView.clear();
        coins.clear();
        healthPackImageView.clear();
        healthpacks.clear();
        enemies.clear();
        enemiesImageView.clear();
    }

    public static void buttonClick() {
        SoundController.buttonPress.play(1);
    }

    private void update() {
        pauseAnimations();
        updateHP();
        updateStamina();
        updateLabels();
        if (!isPaused) {
            if (visibleHealth > 0) {
                updateRegen();
                updateMove();
                attackAnimation();
                ImageView enemyFx = enemySpawn.randomEnemySpawn();
                if (enemyFx != null) {
                    drawPane.getChildren().add(enemyFx);
                }
                collideWithEntities();

                enemyMove.moveEnemies();
            } else if (visibleHealth <= 0) {
                if (!SoundController.youDiedSound.isPlaying()) {
                    SoundController.youDiedSound.play(1);
                }
                SoundController.backgroundMusic.stop();
                SoundController.lowHealth.stop();
                animation.stop();
                opacityValue += 0.01;
                blackScreen.setVisible(true);
                blackScreen.setOpacity(opacityValue);
                youDied.setOpacity(opacityValue);
                if (opacityValue >= 2) {
                    backToMenu.setVisible(true);
                    timer.stop();
                }
            }
        } else if (isPaused) {
            animation.stop();
        }
    }

    private void pauseAnimations() {
        if (isPaused && pauseBackround < 0) {
            pauseTopPanel += 10;
            pauseBackround += 10;
            boxStats.setVisible(true);
            boxMenu.setVisible(true);
            boxTop.setVisible(false);
            boxStats.setLayoutY(pauseBackround + 120);
            topPanel.setLayoutY(pauseTopPanel);
            boxMenu.setY(pauseBackround);
            menuPaused.setLayoutY(pauseTopPanel - 410);
        }
        if (!isPaused && pauseBackround > -520) {
            pauseTopPanel -= 10;
            pauseBackround -= 10;
            topPanel.setLayoutY(pauseTopPanel);
            boxMenu.setY(pauseBackround);
            boxStats.setLayoutY(pauseBackround + 120);
            menuPaused.setLayoutY(pauseTopPanel - 410);
            if (pauseBackround == -520) {
                boxStats.setVisible(false);
                boxTop.setVisible(true);
                boxMenu.setVisible(false);
                menuPaused.setVisible(false);
            }
        }
    }

    public void saveAndQuit() {
        savePlayerData();
        quitGame();
    }

    public void quitGame() {
        buttonClick();
        SoundController.exitButtonSound.play(0.5);
        Stage stage = (Stage) quitGamePaused.getScene().getWindow();
        stage.close();
        System.out.println("Successfully closed");
    }

    public void resumeGame() {
        buttonClick();
        timer.start();
        isPaused = false;
        blackScreenPaused.setOpacity(0);
    }

    private void updateStamina() {
        backgroundStaminabar.setWidth((player.getPlayerMaxStamina() / 100) * fullWidth);
        visibleStaminabar.setWidth((staminaValue / 100) * fullWidth);
    }

    private void updateRegen() {
        if (player.getGameState() == 3) {
            player.setPlayerActualHealth(player.getPlayerActualHealth() + 0.1);
        }
        if (player.getPlayerMaxHealth() != player.getPlayerActualHealth()) {
            player.setPlayerActualHealth(player.getPlayerActualHealth() + player.getPlayerPassiveHealthRegen());
        }
        if (staminaValue < 1) {
            pane.setEffect(null);
            sprintSpeed = 1;
        }
        if (((sprintSpeed > 1) && staminaValue >= 0) && !attackPauseReverse) {
            pane.setEffect(b);
            staminaValue -= 0.6;
        } else if (staminaValue <= player.getPlayerMaxStamina()) {
            staminaValue += (player.getPlayerStaminaRegenSpeed() / 10);
        }
        if (staminaValue >= player.getPlayerMaxStamina()) {
            staminaValue = player.getPlayerMaxStamina();
        }
    }

    private void updateHP() {
        backgroundHealthbar.setWidth((player.getPlayerMaxHealth() / 100) * fullWidth);
        visibleHealthbar.setWidth((player.getPlayerActualHealth() / 100) * fullWidth);
        backgroundHealthbarRed.setWidth((fullWidth * (Character.visibleHealth / 100.0)));
        if (player.getPlayerActualHealth() >= player.getPlayerMaxHealth()) {
            player.setPlayerActualHealth(player.getPlayerMaxHealth());
        }
        if (player.getPlayerActualHealth() < visibleHealth) {
            visibleHealth -= 1;
        } else if (player.getPlayerActualHealth() > visibleHealth) {
            visibleHealth = player.getPlayerActualHealth();
        }
        if (actualHealth2 > 0) {
            actualHealth2 -= 1;
            player.setPlayerActualHealth(player.getPlayerActualHealth() + 1);
        }
        if ((player.getPlayerActualHealth() <= (player.getPlayerMaxHealth() * 0.50)) && (!SoundController.lowHealth.isPlaying()) && !stopLowHealth) {
            SoundController.lowHealth.setCycleCount(AudioClip.INDEFINITE);
            SoundController.lowHealth.play(1);
            ftLowHealth.setFromValue(1);
            ftLowHealth.setToValue(0.4);
            ftLowHealth.setAutoReverse(true);
            ftLowHealth.setCycleCount(Animation.INDEFINITE);
            ftLowHealth.play();
        }
        if ((player.getPlayerActualHealth() > (player.getPlayerMaxHealth() * 0.50)) && (SoundController.lowHealth.isPlaying())) {
            ftLowHealth.stop();
            visibleHealthbar.setOpacity(1);
            SoundController.lowHealth.stop();
        }
    }

    private void updateMove() {
        move();
        attackRect.setX(player.getPlayerX() - 134);
        attackRect.setY(player.getPlayerY() - 134);
        if ((upPressed || downPressed || leftPressed || rightPressed) && !attackPause) {
            if (upPressed && leftPressed) {
                lastKnownDirection2 = 7;
                yMove = -(int) (2 * sprintSpeed);
                xMove = -(int) (2 * sprintSpeed);
                if (sprintSpeed > 1) {
                    b.setAngle(135);
                    b.setRadius(player.getPlayerSpeedModifier() * 2 + 10);
                }
            } else if (upPressed && rightPressed) {
                lastKnownDirection2 = 1;
                xMove = +(int) (2 * sprintSpeed);
                yMove = -(int) (2 * sprintSpeed);
                if (sprintSpeed > 1) {
                    b.setAngle(45);
                    b.setRadius(player.getPlayerSpeedModifier() * 2 + 10);
                }
            } else if (downPressed && leftPressed) {
                lastKnownDirection2 = 5;
                xMove = -(int) (2 * sprintSpeed);
                yMove = +(int) (2 * sprintSpeed);
                if (sprintSpeed > 1) {
                    b.setAngle(315);
                    b.setRadius(player.getPlayerSpeedModifier());
                }
            } else if (downPressed && rightPressed) {
                lastKnownDirection2 = 3;
                xMove = +(int) (2 * sprintSpeed);
                yMove = +(int) (2 * sprintSpeed);
                if (sprintSpeed > 1) {
                    b.setAngle(45);
                    b.setRadius(player.getPlayerSpeedModifier() * 2 + 10);
                }
            } else {
                if (upPressed) {
                    lastKnownDirection2 = 0;
                    yMove = -(int) (2 * sprintSpeed);
                    if (sprintSpeed > 1) {
                        b.setAngle(90);
                        b.setRadius(player.getPlayerSpeedModifier() * 2 + 10);
                    }
                }
                if (downPressed) {
                    lastKnownDirection2 = 4;
                    yMove = +(int) (2 * sprintSpeed);
                    if (sprintSpeed > 1) {
                        b.setAngle(90);
                        b.setRadius(player.getPlayerSpeedModifier() * 2 + 10);
                    }
                }
                if (rightPressed) {
                    lastKnownDirection2 = 2;
                    xMove += (int) (2 * sprintSpeed);
                    if (sprintSpeed > 1) {
                        b.setAngle(0);
                        b.setRadius(player.getPlayerSpeedModifier() * 2 + 10);
                    }
                }
                if (leftPressed) {
                    lastKnownDirection2 = 6;
                    xMove -= (int) (2 * sprintSpeed);
                    if (sprintSpeed > 1) {
                        b.setAngle(0);
                        b.setRadius(player.getPlayerSpeedModifier() * 2 + 10);
                    }
                }
            }
        }
        if ((playerImage.getY() <= 90) && boxTop.getOpacity() > 0.2) {
            ftBoxTop.setToValue(0.2);
            ftBoxTop.setFromValue(1);
            ftBoxTop.play();
        } else if ((playerImage.getY() > 90) && boxTop.getOpacity() < 1) {
            ftBoxTop.setFromValue(0.2);
            ftBoxTop.setToValue(1);
            ftBoxTop.play();
        }
        playerImage.setX(player.playerX - getCamX());
        playerImage.setY(player.playerY - getCamY());
    }

    private void timerDamageEnemy() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                enemyDamaged = false;
            }
        }, 400);
    }

    private void move() {
        moveY();
        moveX();
        if (!upPressed || !downPressed || !leftPressed || !rightPressed) {
            yMove = 0;
            xMove = 0;
        }
    }

    private void moveY() {
        int nextPlayerTileXEnd = (int) ((player.getPlayerX() + player.getWidth()) / 32);
        int nextPlayerTileXStart = (int) (player.getPlayerX() / 32);
        if (yMove < 0) {
            int ty = (int) (player.getPlayerY() + yMove) / 32;
            if (!mapCreator.collision(nextPlayerTileXStart, ty)) {
                if (!mapCreator.collision(nextPlayerTileXEnd, ty)) {
                    player.setPlayerY(player.getPlayerY() + yMove);
                }
            }
        } else if (yMove > 0) {
            int ty = (int) ((player.getPlayerY() + yMove + player.getHeight()) / 32);
            if (!mapCreator.collision((int) (player.getPlayerX() / 32), ty)) {
                if (!mapCreator.collision(nextPlayerTileXEnd, ty)) {
                    player.setPlayerY(player.getPlayerY() + yMove);
                }
            }
        }
    }

    private void moveX() {
        int nextPlayerTileYEnd = (int) ((player.getPlayerY() + player.getHeight()) / 32);
        int nextPlayerTileYStart = (int) (player.getPlayerY() / 32);
        if (xMove < 0) {
            int tx = (int) ((player.getPlayerX() + xMove)) / 32;
            if (!mapCreator.collision(tx, nextPlayerTileYStart)) {
                if (!mapCreator.collision(tx, nextPlayerTileYEnd)) {
                    player.setPlayerX(player.getPlayerX() + xMove);
                }
            }
        }
        if (xMove > 0) {
            int tx = (int) ((player.getPlayerX() + xMove + player.getWidth()) / 32);
            if (!mapCreator.collision(tx, nextPlayerTileYStart)) {
                if (!mapCreator.collision(tx, nextPlayerTileYEnd)) {
                    player.setPlayerX(player.getPlayerX() + xMove);
                }
            }
        }
    }

    private void attackAnimation() {
        if (attackPause && (leftPressed || rightPressed || upPressed || downPressed)) {
            pane.setEffect(null);
            for (int i = 0; i < enemies.size(); i++) {
                ImageView enemyImage = enemiesImageView.get(i);
                if ((playerImage.getBoundsInParent().intersects(enemyImage.getBoundsInParent()))) {
                    enemyDamaged = true;
                    timerDamageEnemy();
                }
            }
            switch (lastKnownDirection) {
                case 0:
                    if (enemyDamaged && !(shiftPressed)) {
                        yMove = +10;
                    } else {
                        yMove = -10;
                    }

                    break;
                case 1:
                    if (enemyDamaged && !(shiftPressed)) {
                        xMove -= 10;
                        yMove += 10;
                    } else {
                        xMove += 10;
                        yMove -= 10;
                    }

                    break;
                case 2:
                    if (enemyDamaged && !(shiftPressed)) {
                        xMove -= 10;
                    } else {
                        xMove += 10;
                    }
                    break;
                case 3:
                    if (enemyDamaged && !(shiftPressed)) {
                        xMove -= 10;
                        yMove -= 10;
                    } else {
                        xMove += 10;
                        yMove += 10;
                    }
                    break;
                case 4:
                    if (enemyDamaged && !(shiftPressed)) {
                        yMove -= 10;
                    } else {
                        yMove += 10;
                    }
                    break;
                case 5:
                    if (enemyDamaged && !(shiftPressed)) {
                        xMove += 10;
                        yMove -= 10;
                    } else {
                        xMove -= 10;
                        yMove += 10;
                    }
                    break;
                case 6:
                    if (enemyDamaged && !(shiftPressed)) {
                        xMove += 10;
                    } else {
                        xMove -= 10;
                    }
                    break;
                case 7:
                    if (enemyDamaged && !(shiftPressed)) {
                        xMove += 10;
                        yMove += 10;
                    } else {
                        xMove -= 10;
                        yMove -= 10;
                    }
                    break;
            }
        }
        if ((upPressed || downPressed || leftPressed || rightPressed || spacePressed) && !attackPause) {
            animation.play();
            if ((spacePressed && !attackPauseReverse) && staminaValue >= 30 && enemies.size() >= 1 && (upPressed || leftPressed || rightPressed || downPressed)) {
                SoundController.attackSound.play(1);
                staminaValue -= 30;
                setAttackPause();
                animation.setOffsetY(128);
                animation.setOffsetX(0);
                if ((upPressed && leftPressed)) {
                    lastKnownDirection = 7;
                } else if (upPressed && rightPressed) {
                    lastKnownDirection = 1;
                } else if (downPressed && leftPressed) {
                    lastKnownDirection = 5;
                } else if (downPressed && rightPressed) {
                    lastKnownDirection = 3;
                } else {
                    if (upPressed) {
                        lastKnownDirection = 0;
                    } else if (rightPressed) {
                        lastKnownDirection = 2;
                    } else if (leftPressed) {
                        lastKnownDirection = 6;
                    } else if (downPressed) {
                        lastKnownDirection = 4;
                    }
                }
            } else {
                if (upPressed && leftPressed) {
                    if (damagePlayerPause) {
                        animation.setOffsetY(64);
                        animation.setOffsetX(576);
                    } else {
                        animation.setOffsetY(64);
                        animation.setOffsetX(192);
                    }
                } else if (upPressed && rightPressed) {
                    if (damagePlayerPause) {
                        animation.setOffsetY(96);
                        animation.setOffsetX(576);
                    } else {
                        animation.setOffsetY(96);
                        animation.setOffsetX(192);
                    }
                } else if (downPressed && leftPressed) {
                    if (damagePlayerPause) {
                        animation.setOffsetY(32);
                        animation.setOffsetX(576);
                    } else {
                        animation.setOffsetY(32);
                        animation.setOffsetX(192);
                    }
                } else if (downPressed && rightPressed) {
                    if (damagePlayerPause) {
                        animation.setOffsetY(0);
                        animation.setOffsetX(576);
                    } else {
                        animation.setOffsetY(0);
                        animation.setOffsetX(192);
                    }
                } else {
                    if (upPressed) {
                        if (damagePlayerPause) {
                            animation.setOffsetY(96);
                            animation.setOffsetX(384);
                        } else {
                            animation.setOffsetY(96);
                            animation.setOffsetX(0);
                        }
                    }
                    if (downPressed) {
                        if (damagePlayerPause) {
                            animation.setOffsetY(0);
                            animation.setOffsetX(384);
                        } else {
                            animation.setOffsetY(0);
                            animation.setOffsetX(0);
                        }
                    }
                    if (rightPressed) {
                        if (damagePlayerPause) {
                            animation.setOffsetY(64);
                            animation.setOffsetX(384);
                        } else {
                            animation.setOffsetY(64);
                            animation.setOffsetX(0);
                        }
                    }
                    if (leftPressed) {
                        if (damagePlayerPause) {
                            animation.setOffsetY(32);
                            animation.setOffsetX(384);
                        } else {
                            animation.setOffsetY(32);
                            animation.setOffsetX(0);
                        }
                    }
                }
            }
        } else {
            animation.stop();
        }
    }

    private void pauseGame() {
        if (escapePressed && !isPaused) {
            menuPaused.setVisible(true);
            blackScreenPaused.setOpacity(0.6);
            isPaused = true;
        } else if (isPaused && escapePressed) {
            blackScreenPaused.setOpacity(0);
            isPaused = false;
        }
    }

    private void damagePlayerPause(int enemyDamage) {
        if (!damagePlayerPause) {
            hitPlayer(enemyDamage);
            SoundController.hitPlayer.play(1);
        }
        damagePlayerPause = true;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                damagePlayerPause = false;
            }
        }, 1000);
    }

    private void damageEnemyPause(int playerDamage, int i) {
        if (!enemy.enemyStunned) {
            hitEnemy(playerDamage, i);
        }
        enemy.setEnemyStunned(true);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < enemies.size(); i++) {
                    enemies.get(i).enemyStunned = false;
                }
            }
        }, 400);
    }

    private void setAttackPause() {
        if (!attackPause) {
            attackPause = true;
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                attackPause = false;
                attackPauseReverse = true;
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        attackPauseReverse = false;
                    }
                }, 600);
            }
        }, 200);
    }

    private void dropItem(Enemy e) {
        int random = (int) Math.floor(Math.random() * 10);
        if (random > 0) {
            spawnCoin(e.getX(), e.getY() + 50, e.getValue());
        } else {
            spawnHealthpack(e.getX(), e.getY() + 50, e.getValue() * 10);
        }
    }

    private void spawnCoin(int x, int y, int value) {
        Image imageCoin = new Image(getClass().getResourceAsStream("/resources/images/money.png"));
        ImageView imageViewCoin = new ImageView(imageCoin);
        coin = new Coin(x, y, value);
        imageViewCoin.setViewport(new Rectangle2D(Coin.offsetX, Coin.offsetY, Coin.width, Coin.height));
        coins.add(coin);
        coinsImageView.add(imageViewCoin);
        drawPane.getChildren().add(imageViewCoin);
    }

    private void spawnHealthpack(int x, int y, int value) {
        Image imageHealthpack = new Image(getClass().getResourceAsStream("/resources/images/health.png"));
        ImageView imageViewHealthpack = new ImageView(imageHealthpack);
        healthpack = new Healthpack(x, y, value);
        imageViewHealthpack.setViewport(new Rectangle2D(Healthpack.offsetX, Healthpack.offsetY, Healthpack.width, Healthpack.height));
        healthpacks.add(healthpack);
        healthPackImageView.add(imageViewHealthpack);
        drawPane.getChildren().add(imageViewHealthpack);
    }

    private void collideWithEntities() {
        for (int i = 0; i < enemiesImageView.size(); i++) {
            ImageView enemyImage = enemiesImageView.get(i);
            enemy = enemies.get(i);
            enemyAni = enemyAnimationList.get(i);
            enemyImage.setTranslateX(enemy.x - getCamX());
            enemyImage.setTranslateY(enemy.y - getCamY());
            gc.setFont(Font.font("Rockwell", 12));
            gc.strokeText("HP : " + enemy.getEnemyHealth(), enemy.getX(), enemy.getY());
            if (playerImage.getBoundsInParent().intersects(enemyImage.getBoundsInParent())) {
                if (!damagePlayerPause && !attackPause) {
                    damagePlayerPause(enemy.getEnemyDamage());
                }
                if (!enemy.enemyStunned && attackPause) {
                    SoundController.hitEnemy.play(1);
                    damageEnemyPause((int) player.getPlayerDamage(), (int) i);
                }
                if (enemy.getEnemyHealth() <= 0) {
                    dropItem(enemy);
                    SoundController.enemyDies.play(1);
                    removeEnemyAnimation = enemyAni;
                    removeEnemyImageView = enemyImage;
                    removeEnemy = enemy;
                }
                if (enemy.getEnemyHealth() <= 0 && player.getGameState() == 5) {
                    stopLowHealth = true;
                    dropItem(enemy);
                    SoundController.enemyDies.play(1);
                    removeEnemyAnimation = enemyAni;
                    removeEnemyImageView = enemyImage;
                    removeEnemy = enemy;
                    isPaused = true;
                    SoundController.lowHealth.stop();
                    victoryScreen.setVisible(true);
                    SoundController.bossMusic.stop();
                    SoundController.victorySound.play(1);
                }
            }
        }

        for (int i = 0; i < coinsImageView.size(); i++) {
            coinImage = coinsImageView.get(i);
            coin = coins.get(i);
            coinImage.setTranslateX(coins.get(i).x - getCamX());
            coinImage.setTranslateY(coins.get(i).y - getCamY());
            if (playerImage.getBoundsInParent().intersects(coinImage.getBoundsInParent())) {
                SoundController.coinPickup.play(1);
                removeCoin = coin;
                removeCoinImageView = coinImage;
                player.setPlayerUserScore(player.getPlayerUserScore() + coin.getValue());
            }
        }

        for (int i = 0; i < healthPackImageView.size(); i++) {
            healthpackImage = healthPackImageView.get(i);
            healthpack = healthpacks.get(i);
            healthpackImage.setTranslateX(healthpacks.get(i).x - getCamX());
            healthpackImage.setTranslateY(healthpacks.get(i).y - getCamY());
            if (playerImage.getBoundsInParent().intersects(healthpackImage.getBoundsInParent())) {
                SoundController.healthPickup.play(1);
                removeHealthpack = healthpack;
                removeHealthpackImageView = healthpackImage;
                Heal(healthpack.getValue());
            }
        }
        healthPackImageView.remove(removeHealthpackImageView);
        healthpacks.remove(removeHealthpack);
        coinsImageView.remove(removeCoinImageView);
        coins.remove(removeCoin);
        enemyAnimationList.remove(removeEnemyAnimation);
        enemies.remove(removeEnemy);
        enemiesImageView.remove(removeEnemyImageView);
        drawPane.getChildren().remove(removeHealthpackImageView);
        drawPane.getChildren().remove(removeCoinImageView);
        drawPane.getChildren().remove(removeEnemyImageView);
    }

    private void Heal(double heal) {
        if (player.getPlayerActualHealth() < player.getPlayerMaxHealth()) {
            actualHealth2 += heal;
        }
    }

    public void coinHealth() {
        if ((player.getPlayerUserScore() >= player.getUpgradeCost()) && (player.getPlayerMaxHealth() < 350) && (!SoundController.buttonUpgrade.isPlaying())) {
            SoundController.buttonUpgrade.play(1);
            player.setPlayerUserScore(player.getPlayerUserScore() - player.getUpgradeCost());
            player.setPlayerMaxHealth(player.getPlayerMaxHealth() + 30);
            player.setUpgradeCost(player.getUpgradeCost() + 1);
        }
    }

    public void coinHealthRegen() {
        if ((player.getPlayerUserScore() >= player.getUpgradeCost()) && (!SoundController.buttonUpgrade.isPlaying()) && (player.getPlayerPassiveHealthRegen() < 0.09)) {
            SoundController.buttonUpgrade.play(1);
            player.setPlayerUserScore(player.getPlayerUserScore() - player.getUpgradeCost());
            player.setPlayerPassiveHealthRegen(player.getPlayerPassiveHealthRegen() + 0.01);
            player.setUpgradeCost(player.getUpgradeCost() + 1);
        }
    }

    public void coinStamina() {
        if ((player.getPlayerUserScore() >= player.getUpgradeCost()) && (player.getPlayerMaxStamina() < 350) && (!SoundController.buttonUpgrade.isPlaying())) {
            SoundController.buttonUpgrade.play(1);
            player.setPlayerUserScore(player.getPlayerUserScore() - player.getUpgradeCost());
            player.setPlayerMaxStamina(player.getPlayerMaxStamina() + 30);
            player.setUpgradeCost(player.getUpgradeCost() + 1);
        }
    }

    public void coinStaminaRegen() {
        if ((player.getPlayerUserScore() >= player.getUpgradeCost()) && (!SoundController.buttonUpgrade.isPlaying()) && (player.getPlayerStaminaRegenSpeed() < 10)) {
            SoundController.buttonUpgrade.play(1);
            player.setPlayerUserScore(player.getPlayerUserScore() - player.getUpgradeCost());
            player.setPlayerStaminaRegenSpeed((player.getPlayerStaminaRegenSpeed() + 1));
            player.setUpgradeCost(player.getUpgradeCost() + 1);
        }
    }

    public void coinSpeedUpgrade() {
        if ((player.getPlayerUserScore() >= player.getUpgradeCost()) && (!SoundController.buttonUpgrade.isPlaying()) && (player.getPlayerSpeedModifier() < 8)) {
            SoundController.buttonUpgrade.play(1);
            player.setPlayerUserScore(player.getPlayerUserScore() - player.getUpgradeCost());
            player.setPlayerSpeedModifier(player.getPlayerSpeedModifier() + 1);
            player.setUpgradeCost(player.getUpgradeCost() + 1);
        }
    }

    public void coinDamageUpgrade() {
        if ((player.getPlayerUserScore() >= player.getUpgradeCost()) && !SoundController.buttonUpgrade.isPlaying()) {
            SoundController.buttonUpgrade.play(1);
            player.setPlayerUserScore(player.getPlayerUserScore() - player.getUpgradeCost());
            player.setPlayerDamage(player.getPlayerDamage() + 1);
            player.setUpgradeCost(player.getUpgradeCost() + 1);
        }
    }

    private void hitPlayer(int damage) {
        player.setPlayerActualHealth(player.getPlayerActualHealth() - damage);
    }

    private void hitEnemy(int damage, int i) {
        enemies.get(i).setAggroed(true);
        enemies.get(i).setEnemyHealth(enemies.get(i).getEnemyHealth() - damage);
    }

    private void updateLabels() {
        if (player.getPlayerUserScore() >= 999) {
            player.setPlayerUserScore(999);
            labelCoin.setTextFill(Color.GREEN);
        }
        labelCoin.setText("x" + player.getPlayerUserScore());
        upgradeCostLabel.setText("Upgrade Cost: " + player.getUpgradeCost() + " Gold");
        if (player.getPlayerMaxHealth() == 360) {
            healthPluss2Label.setTextFill(Color.GREEN);
            healthPluss2Label.setText("(HP) Health Points: " + (int) player.getPlayerActualHealth() + "/" + (int) player.getPlayerMaxHealth() + " MAXED OUT!");
            healthPluss.setVisible(false);
            healthPluss2.setVisible(false);
        } else {
            healthPluss2Label.setText("(HP) Health Points: " + (int) player.getPlayerActualHealth() + "/" + (int) player.getPlayerMaxHealth());
        }
        if (player.getPlayerPassiveHealthRegen() >= 0.09) {
            healthRegenPlussLabel.setTextFill(Color.GREEN);
            healthRegenPlussLabel.setText("HP regen level: " + (int) (player.getPlayerPassiveHealthRegen() * 100 + 1) + " MAXED OUT!");
            healthRegenPluss.setVisible(false);
        } else {
            healthRegenPlussLabel.setText("HP regen level: " + (int) (player.getPlayerPassiveHealthRegen() * 100 + 1));
        }
        if (player.getPlayerMaxStamina() == 360) {
            staminaPluss2Label.setTextFill(Color.GREEN);
            staminaPluss2Label.setText("Stamina: " + (int) Math.floor(staminaValue) + "/" + (int) player.getPlayerMaxStamina() + " MAXED OUT!");
            staminaPluss2.setVisible(false);
            staminaPluss.setVisible(false);
        } else {
            staminaPluss2Label.setText("Stamina: " + (int) Math.floor(staminaValue) + "/" + (int) player.getPlayerMaxStamina());
        }
        if (player.getPlayerStaminaRegenSpeed() >= 10) {
            staminaRegenPlussLabel.setTextFill(Color.GREEN);
            staminaRegenPlussLabel.setText("Stam regen level: " + (int) (player.getPlayerStaminaRegenSpeed()) + " MAXED OUT!");
            staminaRegenPluss.setVisible(false);
        } else {
            staminaRegenPlussLabel.setText("Stam regen level: " + (int) (player.getPlayerStaminaRegenSpeed()));
        }
        if (player.getPlayerSpeedModifier() == 8) {
            speedPlussLabel.setTextFill(Color.GREEN);
            speedPlussLabel.setText("Sprint speed level: " + (int) player.getPlayerSpeedModifier() + " MAXED OUT!");
            speedPluss.setVisible(false);
        } else {
            speedPlussLabel.setText("Sprint speed level: " + (int) player.getPlayerSpeedModifier());
        }
        damagePlussLabel.setText("Damage: " + (int) player.getPlayerDamage());
    }

    public void clear() {
        enemyAnimationList.clear();
        coinsImageView.clear();
        coins.clear();
        healthPackImageView.clear();
        healthpacks.clear();
        enemies.clear();
        enemiesImageView.clear();
    }
}

