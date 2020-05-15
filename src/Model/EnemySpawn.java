package Model;

import Controllerpackage.Controller;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import static Model.ImportantValues.getWorldSizeX;
import static Model.ImportantValues.getWorldSizeY;

public class EnemySpawn extends Controller {

    private double maxEnemiesOnMap = 5;

    public ImageView randomEnemySpawn() {
        int bitPos = 220;
        ImageView enemyImage = null;
        int random = (int) Math.floor(Math.random() * 100);
        int x = Math.max((int) Math.floor(Math.random() * (getWorldSizeX())-64),64);
        int y = Math.max((int) Math.floor(Math.random() * (getWorldSizeY()))-64,96);
        if (random==7&&enemies.size()<maxEnemiesOnMap&&(player.getGameState()!=3)&&(player.getGameState()!=5)&&(player.getGameState()!=4)&&(
                ((x)<(player.getPlayerX() -bitPos))
                        ||
                        ((y)<(player.getPlayerY() -bitPos))
                        ||
                        ((x)>(player.getPlayerX() +bitPos))
                        ||
                        ((y)>(player.getPlayerY() +bitPos))
                        ||
                        ((x)<(player.getPlayerX() -bitPos))
                        ||
                        ((y)>(player.getPlayerY() +bitPos))
                        ||
                        ((x)>(player.getPlayerX() +bitPos))
                        ||
                        ((y)<(player.getPlayerY() -bitPos))
                )){
                Image imageEnemyPNG = null;
                if (player.getGameState()==0){
                    maxEnemiesOnMap=5;
                    imageEnemyPNG = new Image("/resources/images/mushroom.png");
                    enemy = new Enemy(x,y, 2, 5, x,y, false,1);
                }else if (player.gameState==1){
                    maxEnemiesOnMap=7;
                    imageEnemyPNG = new Image("/resources/images/blueBunny.png");
                    enemy = new Enemy(x,y, 5, 10, x,y, false,2);
                }else if (player.gameState==2){
                    maxEnemiesOnMap=25;
                    imageEnemyPNG = new Image("/resources/images/redLamp.png");
                    enemy = new Enemy(x,y, 150, 100, x,y,false,25);
                }else if (player.gameState==6){
                    maxEnemiesOnMap=10;
                    imageEnemyPNG = new Image("/resources/images/redBunny.png");
                    enemy = new Enemy(x,y, 15, 30, x,y, false,7);
                }else if (player.gameState==7){
                    maxEnemiesOnMap=15;
                    imageEnemyPNG = new Image("/resources/images/stoneGolem.png");
                    enemy = new Enemy(x,y, 60, 60, x,y, false,15);
                }
                enemyImage = new ImageView(imageEnemyPNG);
                enemyImage.setViewport(new Rectangle2D(Enemy.offsetX, Enemy.offsetY, Enemy.width, Enemy.height));
                enemyAnimation = new SpriteAnimation(enemyImage, Duration.millis(400), Enemy.count, Enemy.columns, Enemy.offsetX, Enemy.offsetY, Enemy.width, Enemy.height);
                enemyAnimation.play();
                enemyAnimationList.add(enemyAnimation);
                enemiesImageView.add(enemyImage);
                enemies.add(enemy);
            }
            else if (player.getGameState()==5&&enemies.size()<1){
                Image imageEnemyPNG = new Image("/resources/images/evilWitch.png");
                enemyImage = new ImageView(imageEnemyPNG);
                enemy = new Enemy(420,110, 1000, 200, 420,110, false,400);
                enemyImage.setViewport(new Rectangle2D(Enemy.offsetX, Enemy.offsetY, Enemy.width, Enemy.height));
                enemyAnimation = new SpriteAnimation(enemyImage, Duration.millis(400), Enemy.count, Enemy.columns, Enemy.offsetX, Enemy.offsetY, Enemy.width, Enemy.height);
                enemyAnimation.play();
                enemyAnimationList.add(enemyAnimation);
                enemiesImageView.add(enemyImage);
                enemies.add(enemy);
            }
            return enemyImage;
    }
}

