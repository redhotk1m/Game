package view;

import static Model.ImportantValues.*;
import static Controllerpackage.Controller.*;

public class GameCamera {

    private static double camX;
    private static double camY;

    public static void gameCameraUpdate() {
        double offsetMaxX;
        double offsetMaxY;
        double offsetMinX = 0;
        double offsetMinY = 0;
        offsetMaxX = getWorldSizeX() - getViewportSizeX();
        offsetMaxY = getWorldSizeY() - getViewportSizeY();
        setCamX((player.playerX)-(getViewportSizeX()/2));
        setCamY((player.playerY)-(getViewportSizeY()/2));

        if (camX > offsetMaxX){
        camX = offsetMaxX;
        }
        else if (camX<offsetMinX){
        camX = offsetMinX;
        }
        if (camY > offsetMaxY){
        camY = offsetMaxY;
        }
        else if (camY<offsetMinY) {
            camY = offsetMinY;
        }
    }

    public static double getCamX() {
        return camX;
    }

    private static void setCamX(double camX) {
        GameCamera.camX = camX;
    }

    public static double getCamY() {
        return camY;
    }

    private static void setCamY(double camY) {
        GameCamera.camY = camY;
    }

}
