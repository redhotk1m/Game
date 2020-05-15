package Model;

import Controllerpackage.Controller;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import static Controllerpackage.Controller.*;

public class EnemyMovement {

    private boolean moveEnemyNorth = false;
    private boolean moveEnemySouth = false;
    private boolean moveEnemyEast = false;
    private boolean moveEnemyWest = false;
    private ArrayList<ImageView> enemyView;
    private ArrayList<SpriteAnimation> enemyAnimation;

    public void setEnemyArrays(ArrayList<ImageView> enemyView, ArrayList<SpriteAnimation>  enemyAnimation) {
        this.enemyView = enemyView;
        this.enemyAnimation = enemyAnimation;
    }

    private void setEnemyAnimation() {
        if (moveEnemyNorth && moveEnemyWest) {
            if (!enemy.enemyStunned) {
                Controller.enemyAni.setOffsetX(13 * 32);
                Controller.enemyAni.setOffsetY(32);
            } else if (lastKnownDirection==7) {
                Controller.enemyAni.setOffsetX(5 * 32);
                Controller.enemyAni.setOffsetY(32*3);
            } else if (lastKnownDirection==3) {
                Controller.enemyAni.setOffsetX(8 * 32);
                Controller.enemyAni.setOffsetY(32);
            }
        } else if (moveEnemyNorth && moveEnemyEast) {
            if (!enemy.enemyStunned) {
                Controller.enemyAni.setOffsetX(0);
                Controller.enemyAni.setOffsetY(32);
            } else if (lastKnownDirection==1){
                Controller.enemyAni.setOffsetX(8 * 32);
                Controller.enemyAni.setOffsetY(32*3);
            } else if (lastKnownDirection==5) {
                Controller.enemyAni.setOffsetX(5 * 32);
                Controller.enemyAni.setOffsetY(32);
            }
        } else if (moveEnemySouth && moveEnemyEast) {
            if (!enemy.enemyStunned) {
                Controller.enemyAni.setOffsetX(0);
                Controller.enemyAni.setOffsetY(3 * 32);
            } else if (lastKnownDirection==3) {
                Controller.enemyAni.setOffsetX(8 * 32);
                Controller.enemyAni.setOffsetY(32);
            } else if (lastKnownDirection==7) {
                Controller.enemyAni.setOffsetX(5 * 32);
                Controller.enemyAni.setOffsetY(32*3);
            }
        } else if (moveEnemySouth && moveEnemyWest) {
            if (!enemy.enemyStunned) {
                Controller.enemyAni.setOffsetX(13 * 32);
                Controller.enemyAni.setOffsetY(3 * 32);
            } else if (lastKnownDirection==5) {
                Controller.enemyAni.setOffsetX(5 * 32);
                Controller.enemyAni.setOffsetY(32);
            } else if (lastKnownDirection==1){
                Controller.enemyAni.setOffsetX(8 * 32);
                Controller.enemyAni.setOffsetY(32*3);
            }
        } else {
            if (moveEnemyNorth) {
                if (!enemy.enemyStunned) {
                    Controller.enemyAni.setOffsetX(0);
                    Controller.enemyAni.setOffsetY(0);
                } else if (lastKnownDirection==0) {
                    Controller.enemyAni.setOffsetX(5 * 32);
                    Controller.enemyAni.setOffsetY(32*4);
                } else if (lastKnownDirection==4) {
                    Controller.enemyAni.setOffsetX(5 * 32);
                    Controller.enemyAni.setOffsetY(0);
                }
            } else if (moveEnemySouth) {
                if (!enemy.enemyStunned) {
                    Controller.enemyAni.setOffsetX(0);
                    Controller.enemyAni.setOffsetY(32 * 4);
                } else if (lastKnownDirection==4) {
                    Controller.enemyAni.setOffsetX(5 * 32);
                    Controller.enemyAni.setOffsetY(0);
                } else if (lastKnownDirection==0) {
                    Controller.enemyAni.setOffsetX(5 * 32);
                    Controller.enemyAni.setOffsetY(32 * 4);
                }
            } else if (moveEnemyWest) {
                if (!enemy.enemyStunned) {
                    Controller.enemyAni.setOffsetX(13 * 32);
                    Controller.enemyAni.setOffsetY(2 * 32);
                } else if (lastKnownDirection==6) {
                    Controller.enemyAni.setOffsetX(5 * 32);
                    Controller.enemyAni.setOffsetY(32 * 2);
                } else if (lastKnownDirection==2) {
                    Controller.enemyAni.setOffsetX(8 * 32);
                    Controller.enemyAni.setOffsetY(32 * 2);
                }
            } else if (moveEnemyEast) {
                if (!enemy.enemyStunned) {
                    Controller.enemyAni.setOffsetX(0);
                    Controller.enemyAni.setOffsetY(2 * 32);
                } else if (lastKnownDirection==2) {
                    Controller.enemyAni.setOffsetX(8 * 32);
                    Controller.enemyAni.setOffsetY(32 * 2);
                } else if (lastKnownDirection==6) {
                    Controller.enemyAni.setOffsetX(5 * 32);
                    Controller.enemyAni.setOffsetY(32 * 2);
                }
            }
        }
    }

    private void moveEnemyNorth(){
        if (moveEnemyNorth&&!enemy.enemyStunned) {
            enemy.setY(enemy.getY() - 1);
        }
    }
    private void moveEnemySouth(){
        if (moveEnemySouth&&!enemy.enemyStunned) {
            enemy.setY(enemy.getY() + 1);
        }
    }
    private void moveEnemyWest(){
        if (moveEnemyWest&&!enemy.enemyStunned) {
            enemy.setX(enemy.getX() - 1);
        }
    }
    private void moveEnemyEast(){
        if (moveEnemyEast&&!enemy.enemyStunned) {
            enemy.setX(enemy.getX() + 1);
        }
    }

    public void moveEnemies() {

            for (int i = 0; i < enemyView.size(); i++) {
                enemyAni = enemyAnimation.get(i);
                enemy = enemies.get(i);
                ImageView enemyImage = enemyView.get(i);
                if (!enemyImage.getBoundsInParent().intersects(attackRect.getBoundsInParent())&&!enemy.isAggroed){
                    if (enemy.x==enemy.getBirthPlaceX()&&enemy.y==enemy.getBirthPlaceY()){
                        enemyAni.setOffsetX(0);
                        enemyAni.setOffsetY(32*5);
                    }
                    if (enemy.x>enemy.getBirthPlaceX()){
                        moveEnemyWest=true;
                        moveEnemyWest();
                    }else{
                        moveEnemyWest=false;
                    }
                    if (enemy.x<enemy.getBirthPlaceX()){
                        moveEnemyEast=true;
                        moveEnemyEast();
                    }else{
                        moveEnemyEast=false;
                    }
                    if (enemy.y>enemy.getBirthPlaceY()){
                        moveEnemyNorth=true;
                        moveEnemyNorth();
                    }else{
                        moveEnemyNorth=false;
                    } if (enemy.y<enemy.getBirthPlaceY()){
                        moveEnemySouth=true;
                        moveEnemySouth();
                    }else{
                        moveEnemySouth=false;
                    }
                }
                if (enemyImage.getBoundsInParent().intersects(attackRect.getBoundsInParent())||enemy.isAggroed){
                if (enemy.x > player.getPlayerX()) {
                    moveEnemyWest=true;
                    moveEnemyWest();
                }else{
                    moveEnemyWest=false;
                }
                if (enemy.x < player.getPlayerX()) {
                    moveEnemyEast = true;
                    moveEnemyEast();
                }else {
                    moveEnemyEast=false;
                }
                if (enemy.y > player.getPlayerY()) {
                    moveEnemyNorth=true;
                    moveEnemyNorth();
                }else{
                    moveEnemyNorth=false;
                }
                if (enemy.y < player.getPlayerY()) {
                        moveEnemySouth = true;
                    moveEnemySouth();
                }else{
                    moveEnemySouth=false;
                }

            }
            setEnemyAnimation();
        }
    }
}
