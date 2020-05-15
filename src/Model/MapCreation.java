package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static Controllerpackage.Controller.player;
import static Controllerpackage.SoundController.backgroundMusic;
import static Controllerpackage.SoundController.bossMusic;
import static Model.ImportantValues.setWorldSizeX;
import static Model.ImportantValues.setWorldSizeY;
import static view.GameCamera.getCamX;
import static view.GameCamera.getCamY;

public class MapCreation {

    public int width, height;
    private int[][] tiles;
    private int rows = 20;
    public int columns = 32;
    public static URL url;
    private static int[] mapArray;
    private Image mapImage = new Image("/resources/images/overWorldMap.png");
    private Image mapImage2 = new Image("/resources/images/cave_32.png");
    private Image dirtRoad = new Image("/resources/images/textures.png");
    private Image trees = new Image("/resources/images/Trees.png");
    private Image house = new Image("/resources/images/Inner_32.png");
    private Image ladder = new Image("/resources/images/rope_ladder.png");
    private GraphicsContext gc;
    private GraphicsContext gc3;
    private AnchorPane drawPane;
    private ArrayList<ImageView> enemyImages;
    public boolean changeMap = false;
    public void setRows(int rows) {
        this.rows = rows;
    }
    public int getColumns() {
        return columns;
    }
    public void setColumns(int columns) {
        this.columns = columns;
    }

    public MapCreation(GraphicsContext gc, GraphicsContext gc3, AnchorPane drawPane){
        this.gc=gc;
        this.gc3=gc3;
        this.drawPane=drawPane;
    }

    public void setEnemyView(ArrayList<ImageView> enemyImages) {
        this.enemyImages = enemyImages;
    }

    public void drawMap() throws IOException, URISyntaxException {
        int xStart = (int) Math.max(0, getCamX() / 32);
        int xEnd = (int) Math.min(900, (getCamX() + 900) / 32 + 1);
        int yStart = (int) Math.max(0, getCamY() / 32);
        int yEnd = (int) Math.min(600, (getCamY() + 600) / 32 + 1);
        int xa = xStart;
        int ya = yStart;
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                if (xa < tiles[0].length && ya < tiles.length) {
                    gc.drawImage(mapImage, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                    if (tiles[ya][xa] == 52) {
                        gc.drawImage(mapImage, 32 * 6, 10 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 2) {
                        gc.drawImage(mapImage, 32 * 4, 10 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 53) {
                        gc.drawImage(mapImage, 32 * 5, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 54) {
                        gc.drawImage(mapImage, 32 * 4, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 3) {
                        gc.drawImage(mapImage, 32 * 6, 4 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 4) {
                        gc.drawImage(mapImage, 32 * 7, 4 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 5) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 8, 4 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 6) {
                        gc.drawImage(mapImage, 32 * 9, 4 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 7) {
                        gc.drawImage(mapImage, 32 * 10, 4 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 8) {
                        gc.drawImage(mapImage, 32 * 6, 3 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 9) {
                        gc.drawImage(mapImage, 32 * 7, 3 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 10) {
                        gc.drawImage(mapImage, 32 * 8, 3 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 11) {
                        gc.drawImage(mapImage, 32 * 9, 3 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 12) {
                        gc.drawImage(mapImage, 32 * 10, 3 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 13) {
                        gc3.drawImage(mapImage, 32 * 6, 2 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 14) {
                        gc3.drawImage(mapImage, 32 * 7, 2 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 15) {
                        gc3.drawImage(mapImage, 32 * 8, 2 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 16) {
                        gc3.drawImage(mapImage, 32 * 9, 2 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 17) {
                        gc3.drawImage(mapImage, 32 * 10, 2 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 18) {
                        gc3.drawImage(mapImage, 32 * 6, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 19) {
                        gc3.drawImage(mapImage, 32 * 7, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 20) {
                        gc3.drawImage(mapImage, 32 * 8, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 21) {
                        gc3.drawImage(mapImage, 32 * 9, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 22) {
                        gc3.drawImage(mapImage, 32 * 10, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 23) {
                        gc3.drawImage(mapImage, 32 * 6, 0, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 24) {
                        gc3.drawImage(mapImage, 32 * 7, 0, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 25) {
                        gc3.drawImage(mapImage, 32 * 8, 0, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 26) {
                        gc3.drawImage(mapImage, 32 * 9, 0, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 27) {
                        gc3.drawImage(mapImage, 32 * 10, 0, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 28) {
                        gc.drawImage(mapImage, 32 * 2, 6 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 29) {
                        gc.drawImage(mapImage, 32 * 3, 6 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 30) {
                        gc.drawImage(mapImage, 32 * 4, 6 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 31) {
                        gc.drawImage(mapImage, 32 * 2, 7 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 32) {
                        gc.drawImage(mapImage, 32 * 3, 7 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 33) {
                        gc.drawImage(mapImage, 32 * 4, 7 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 34) {
                        gc.drawImage(mapImage, 32 * 2, 8 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 35) {
                        gc.drawImage(mapImage, 32 * 3, 8 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 36) {
                        gc.drawImage(mapImage, 32 * 4, 8 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 37) {
                        gc3.drawImage(mapImage, 32 * 22, 9 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 38) {
                        gc3.drawImage(mapImage, 32 * 23, 9 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 39) {
                        gc3.drawImage(mapImage, 32 * 24, 9 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 40) {
                        gc.drawImage(mapImage, 32 * 22, 10 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 41) {
                        gc.drawImage(mapImage, 32 * 23, 10 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 42) {
                        gc.drawImage(mapImage, 32 * 24, 10 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 43) {
                        gc.drawImage(mapImage, 32 * 22, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 44) {
                        gc.drawImage(mapImage, 32 * 23, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 45) {
                        gc.drawImage(mapImage, 32 * 24, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 46) {
                        gc.drawImage(mapImage, 32 * 13, 15 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 47) {
                        gc.drawImage(mapImage, 32 * 14, 15 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 48) {
                        gc.drawImage(mapImage, 32 * 13, 32 * 16, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 49) {
                        gc.drawImage(mapImage, 32 * 14, 32 * 16, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 50) {
                        gc.drawImage(mapImage2, 32, 12 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 51) {
                        gc.drawImage(mapImage2, 0, 0, 16, 16, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage2, 0, 16 * 4, 16, 16, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 55) {
                        gc3.drawImage(mapImage, 32 * 3, 32 * 29, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 56) {
                        gc3.drawImage(mapImage, 32 * 3, 32 * 30, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 57) {
                        gc.drawImage(mapImage, 32 * 3, 32 * 31, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 58) {
                        gc3.drawImage(mapImage, 32 * 4, 32 * 29, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 59) {
                        gc3.drawImage(mapImage, 32 * 4, 32 * 30, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 60) {
                        gc.drawImage(mapImage, 32 * 25, 32 * 18, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 61) {
                        gc.drawImage(mapImage, 32 * 25, 32 * 19, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 62) {
                        gc3.drawImage(mapImage, 32 * 28, 32 * 4, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 63) {
                        gc3.drawImage(mapImage, 32 * 29, 32 * 4, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 64) {
                        gc3.drawImage(mapImage, 32 * 30, 32 * 4, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 65) {
                        gc.drawImage(mapImage, 32 * 28, 32 * 5, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 66) {
                        gc.drawImage(mapImage, 32 * 29, 32 * 5, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 67) {
                        gc.drawImage(mapImage, 32 * 30, 32 * 5, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 68) {
                        gc.drawImage(mapImage, 32 * 31, 32 * 4, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 69) {
                        gc.drawImage(mapImage, 32 * 32, 32 * 4, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 70) {
                        gc.drawImage(mapImage, 32 * 31, 32 * 3, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 71) {
                        gc.drawImage(mapImage, 32 * 32, 32 * 3, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 72) {
                        gc.drawImage(mapImage, 32 * 32, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 73) {
                        gc.drawImage(mapImage, 32 * 32, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 74) {
                        gc.drawImage(mapImage, 32 * 4, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 75) {
                        gc.drawImage(mapImage, 32 * 5, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 76) {
                        gc.drawImage(mapImage, 32 * 5, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 77) {
                        gc.drawImage(mapImage, 32 * 4, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 78) {
                        gc3.drawImage(mapImage, 32 * 8, 32 * 31, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 79) {
                        gc3.drawImage(mapImage, 32 * 9, 32 * 31, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 80) {
                        gc.drawImage(mapImage, 32 * 8, 32 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 81) {
                        gc.drawImage(mapImage, 32 * 9, 32 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 82) {
                        gc.drawImage(mapImage, 32 * 8, 32 * 33, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 83) {
                        gc.drawImage(mapImage, 32 * 9, 32 * 33, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 84) {
                        gc.drawImage(mapImage, 32 * 26, 32 * 7, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 85) {
                        gc.drawImage(mapImage, 32 * 26, 32 * 6, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 86) {
                        gc.drawImage(mapImage, 32 * 26, 32 * 5, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 87) {
                        gc.drawImage(mapImage, 32 * 26, 32 * 4, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 88) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 89) {
                        gc3.drawImage(trees, 32 * 3, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 90) {
                        gc3.drawImage(trees, 32 * 3, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 91) {
                        gc.drawImage(trees, 32 * 3, 32 * 3, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 92) {
                        gc3.drawImage(trees, 32 * 4, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 93) {
                        gc3.drawImage(trees, 32 * 4, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 94) {
                        gc.drawImage(trees, 32 * 4, 32 * 3, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 95) {
                        gc3.drawImage(trees, 32 * 5, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 96) {
                        gc3.drawImage(trees, 32 * 5, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 97) {
                        gc3.drawImage(trees, 32 * 4, 0, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 98) {
                        gc.drawImage(mapImage, 32 * 37, 32 * 8, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 99) {
                        gc.drawImage(mapImage, 32 * 37, 32 * 9, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 100) {
                        gc.drawImage(mapImage, 32 * 15, 32 * 30, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 35, 32 * 8, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 101) {
                        gc.drawImage(mapImage, 32 * 15, 32 * 30, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 36, 32 * 8, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 102) {
                        gc.drawImage(mapImage, 32 * 15, 32 * 30, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 35, 32 * 9, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 103) {
                        gc.drawImage(mapImage, 32 * 15, 32 * 30, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 36, 32 * 9, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 104) {
                        gc.drawImage(mapImage, 32 * 36, 32 * 9, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 105) {
                        gc.drawImage(mapImage, 32 * 36, 32 * 9, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 106) {
                        gc.drawImage(mapImage, 0, 32 * 27, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 107) {
                        gc.drawImage(mapImage, 32, 32 * 27, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 108) {
                        gc.drawImage(mapImage, 32 * 2, 32 * 27, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 109) {
                        gc.drawImage(mapImage, 32, 32 * 28, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 110) {
                        gc.drawImage(mapImage, 0, 32 * 28, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 111) {
                        gc.drawImage(mapImage, 32 * 2, 32 * 28, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 112) {
                        gc.drawImage(mapImage, 0, 32 * 26, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 113) {
                        gc.drawImage(mapImage, 32, 32 * 26, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 114) {
                        gc.drawImage(mapImage, 32 * 2, 32 * 26, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 115) {
                        gc3.drawImage(mapImage, 0, 32 * 25, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 116) {
                        gc3.drawImage(mapImage, 32, 32 * 25, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 117) {
                        gc3.drawImage(mapImage, 32 * 2, 32 * 25, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 118) {
                        gc3.drawImage(mapImage, 0, 32 * 24, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 119) {
                        gc3.drawImage(mapImage, 32, 32 * 24, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 120) {
                        gc3.drawImage(mapImage, 32 * 2, 32 * 24, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 121) {
                        gc3.drawImage(mapImage, 0, 32 * 23, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 122) {
                        gc3.drawImage(mapImage, 32, 32 * 23, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 123) {
                        gc3.drawImage(mapImage, 32 * 2, 32 * 23, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 124) {
                        gc3.drawImage(mapImage, 0, 32 * 22, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 125) {
                        gc3.drawImage(mapImage, 32, 32 * 22, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc3.drawImage(mapImage, 32 * 3, 32 * 31, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 126) {
                        gc3.drawImage(mapImage, 32 * 2, 32 * 22, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 127) {
                        gc3.drawImage(mapImage, 0, 32 * 21, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 128) {
                        gc3.drawImage(mapImage, 32, 32 * 21, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc3.drawImage(mapImage, 32 * 3, 32 * 30, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 129) {
                        gc3.drawImage(mapImage, 32 * 2, 32 * 21, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc3.drawImage(mapImage, 32 * 4, 32 * 30, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 130) {
                        gc3.drawImage(mapImage, 32 * 22, 32 * 3, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 131) {
                        gc3.drawImage(mapImage, 32 * 23, 32 * 3, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 132) {
                        gc3.drawImage(mapImage, 32 * 24, 32 * 3, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 133) {
                        gc3.drawImage(mapImage, 32 * 22, 32 * 4, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 134) {
                        gc3.drawImage(mapImage, 32 * 23, 32 * 4, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 135) {
                        gc3.drawImage(mapImage, 32 * 24, 32 * 4, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 136) {
                        gc.drawImage(mapImage, 32 * 22, 32 * 5, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 137) {
                        gc.drawImage(mapImage, 32 * 23, 32 * 5, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 138) {
                        gc.drawImage(mapImage, 32 * 24, 32 * 5, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 139) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 140) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 16, 32 * 6, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 141) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 16, 32 * 5, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 142) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 16, 32 * 4, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 143) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 17, 32 * 6, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 144) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 17, 32 * 5, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 145) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 18, 32 * 6, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 146) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 18, 32 * 5, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 147) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 18, 32 * 4, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 148) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 10, 32 * 7, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 149) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 11, 32 * 7, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 150) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 12, 32 * 7, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 151) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 10, 32 * 8, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 152) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 11, 32 * 8, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 153) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 12, 32 * 8, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 154) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 10, 32 * 9, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 155) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 11, 32 * 9, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 156) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 12, 32 * 9, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 157) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 12, 32 * 10, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 158) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 13, 32 * 10, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 159) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 12, 32 * 11, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 160) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 13, 32 * 11, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 161) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 12, 32 * 12, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 162) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 13, 32 * 12, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 163) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc3.drawImage(house, 32 * 18, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 164) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 18, 32 * 2, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 165) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 18, 32 * 3, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 166) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc3.drawImage(house, 32 * 17, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 167) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 17, 32 * 2, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 168) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 17, 32 * 3, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 169) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 0, 32 * 9, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 170) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 0, 32 * 8, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 171) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 0, 32 * 7, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 172) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 0, 32 * 6, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 173) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32, 32 * 9, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 174) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32, 32 * 8, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 175) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32, 32 * 7, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 176) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32, 32 * 6, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 177) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 2, 32 * 9, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 178) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 2, 32 * 8, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 179) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 2, 32 * 7, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 180) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 2, 32 * 6, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 181) {
                        gc.drawImage(house, 0, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 182) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 14, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 183) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 15, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 184) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 16, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 185) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 17, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 186) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 12, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 187) {
                        gc.drawImage(house, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                        gc.drawImage(house, 32 * 13, 0, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 188) {
                        gc.drawImage(mapImage2, 32, 32 * 4, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 189) {
                        gc.drawImage(mapImage2, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage2, 0, 32 * 5, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 190) {
                        gc.drawImage(mapImage2, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage2, 0, 32 * 6, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 191) {
                        gc.drawImage(mapImage, 32 * 13, 32 * 16, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(ladder, 0, 32 * 3, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 192) {
                        gc.drawImage(mapImage, 32 * 13, 32 * 16, 32, 32, x * 32, y * 32, 32, 32);
                        gc3.drawImage(ladder, 0, 32 * 2, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 193) {
                        gc.drawImage(mapImage, 32 * 13, 32 * 16, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(ladder, 0, 32, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 194) {
                        gc.drawImage(mapImage2, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 11, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 195) {
                        gc.drawImage(mapImage2, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 12, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 196) {
                        gc.drawImage(mapImage2, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 13, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 197) {
                        gc.drawImage(mapImage2, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 11, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 198) {
                        gc.drawImage(mapImage2, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 12, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 199) {
                        gc.drawImage(mapImage2, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 13, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 200) {
                        gc.drawImage(mapImage2, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 11, 32 * 3, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 201) {
                        gc.drawImage(mapImage2, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 12, 32 * 3, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 202) {
                        gc.drawImage(mapImage2, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 13, 32 * 3, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 203) {
                        gc.drawImage(mapImage, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage2, 0, 32 * 5, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 204) {
                        gc.drawImage(mapImage, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage2, 0, 32 * 6, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 205) {
                        gc.drawImage(mapImage, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 11, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 206) {
                        gc.drawImage(mapImage, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 12, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 207) {
                        gc.drawImage(mapImage, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 13, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 208) {
                        gc.drawImage(mapImage, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 11, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 209) {
                        gc.drawImage(mapImage, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 12, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 210) {
                        gc.drawImage(mapImage, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 13, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 211) {
                        gc.drawImage(mapImage, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 11, 32 * 3, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 212) {
                        gc.drawImage(mapImage, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 12, 32 * 3, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 213) {
                        gc.drawImage(mapImage, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(trees, 32 * 13, 32 * 3, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 214) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage2, 32 * 8, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 215) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage2, 32 * 8, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 216) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage2, 32 * 9, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 217) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage2, 32 * 9, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 218) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 35, 32 * 5, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 219) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 35, 32 * 6, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 220) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 36, 32 * 5, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 221) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 36, 32 * 6, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 222) {
                        gc.drawImage(mapImage, 32 * 3, 6 * 32, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 5, 6 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 223) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 6, 6 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 224) {
                        gc.drawImage(mapImage, 32 * 3, 6 * 32, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 7, 6 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 225) {
                        gc.drawImage(mapImage, 32 * 3, 7 * 32, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 5, 7 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 226) {
                        gc.drawImage(mapImage, 32 * 6, 7 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 227) {
                        gc.drawImage(mapImage, 32 * 3, 7 * 32, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 7, 7 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 228) {
                        gc.drawImage(mapImage, 32 * 3, 8 * 32, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 5, 8 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 229) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 6, 8 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 230) {
                        gc.drawImage(mapImage, 32 * 3, 8 * 32, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 7, 8 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 231) {
                        gc.drawImage(mapImage, 32 * 6, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 232) {
                        gc.drawImage(mapImage, 0, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 233) {
                        gc.drawImage(mapImage, 32, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 234) {
                        gc.drawImage(mapImage, 32 * 2, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 235) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 0, 17 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 236) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 0, 18 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 237) {
                        gc.drawImage(mapImage, 0, 17 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 238) {
                        gc.drawImage(mapImage, 0, 18 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 239) {
                        gc.drawImage(mapImage, 0, 19 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 240) {
                        gc.drawImage(mapImage, 32, 19 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 241) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 0, 19 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 242) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32, 19 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 243) {
                        gc.drawImage(mapImage2, 32, 0, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 244) {
                        gc.drawImage(mapImage2, 32 * 2, 0, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 245) {
                        gc.drawImage(mapImage2, 32 * 3, 0, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 246) {
                        gc.drawImage(mapImage2, 32, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 247) {
                        gc.drawImage(mapImage2, 32 * 2, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 248) {
                        gc.drawImage(mapImage2, 32 * 3, 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 249) {
                        gc.drawImage(mapImage2, 32, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 250) {
                        gc.drawImage(mapImage2, 32 * 2, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 251) {
                        gc.drawImage(mapImage2, 32 * 3, 32 * 2, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 252) {
                        gc.drawImage(mapImage, 32 * 2, 9 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 253) {
                        gc.drawImage(mapImage, 32 * 3, 9 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 255) {
                        gc.drawImage(mapImage, 32 * 2, 10 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 256) {
                        gc.drawImage(mapImage, 32 * 3, 10 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 257) {
                        gc.drawImage(mapImage, 32 * 4, 12 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 258) {
                        gc.drawImage(mapImage, 32 * 5, 12 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 259) {
                        gc.drawImage(mapImage, 32 * 6, 12 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 260) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage, 32 * 7, 12 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 261) {
                        gc.drawImage(mapImage, 32 * 6, 14 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 262) {
                        gc.drawImage(mapImage, 32 * 5, 14 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 263) {
                        gc.drawImage(mapImage, 32 * 4, 14 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 264) {
                        gc.drawImage(mapImage, 32 * 6, 13 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 265) {
                        gc.drawImage(mapImage, 32 * 5, 13 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 266) {
                        gc.drawImage(mapImage, 32 * 4, 13 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 267) {
                        gc.drawImage(mapImage, 32 * 6, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 268) {
                        gc.drawImage(mapImage, 32 * 5, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 269) {
                        gc.drawImage(mapImage, 32 * 4, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 270) {
                        gc3.drawImage(mapImage, 32 * 5, 13 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 271) {
                        gc.drawImage(mapImage, 32 * 13, 32 * 16, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(ladder, 0, 32 * 2, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 272) {
                        gc.drawImage(mapImage, 0, 32 * 29, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 273) {
                        gc.drawImage(mapImage, 0, 32 * 30, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 274) {
                        gc.drawImage(mapImage, 0, 32 * 31, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 275) {
                        gc.drawImage(mapImage, 32, 32 * 29, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 276) {
                        gc.drawImage(mapImage, 32, 32 * 30, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 277) {
                        gc.drawImage(mapImage, 32, 32 * 31, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 278) {
                        gc.drawImage(mapImage, 32 * 2, 32 * 29, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 279) {
                        gc.drawImage(mapImage, 32 * 2, 32 * 30, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 280) {
                        gc.drawImage(mapImage, 32 * 2, 32 * 31, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 281) {
                        gc.drawImage(dirtRoad, 0, 0, 32, 32, x * 32, y * 32, 32, 32);
                        gc.drawImage(mapImage2, 0, 32 * 5, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 282) {
                        gc.drawImage(mapImage, 32 * 4, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 283) {
                        gc.drawImage(mapImage, 32 * 6, 11 * 32, 32, 32, x * 32, y * 32, 32, 32);
                    } else if (tiles[ya][xa] == 284) {
                        gc.drawImage(mapImage, 32 * 14, 32 * 29, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 285) {
                        gc.drawImage(mapImage, 32 * 15, 32 * 29, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 286) {
                        gc.drawImage(mapImage, 32 * 16, 32 * 29, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 287) {
                        gc.drawImage(mapImage, 32 * 14, 32 * 30, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 288) {
                        gc.drawImage(mapImage, 32 * 15, 32 * 30, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 289) {
                        gc.drawImage(mapImage, 32 * 16, 32 * 30, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 290) {
                        gc.drawImage(mapImage, 32 * 14, 32 * 31, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 291) {
                        gc.drawImage(mapImage, 32 * 15, 32 * 31, 32, 32, xa * 32, ya * 32, 32, 32);
                    } else if (tiles[ya][xa] == 292) {
                        gc.drawImage(mapImage, 32 * 16, 32 * 31, 32, 32, xa * 32, ya * 32, 32, 32);
                    }
                    xa++;
                }
            }
            ya++;
            xa = xStart;
            if (player.playerY > 640 && player.playerX > 378 && player.playerX < 515 && player.getGameState() == 0) {
                changeMap=true;
                changeMap(1);
            } else if (player.playerY < 10 && (player.playerX > 380 && player.playerX < 505) && player.getGameState() == 1) {
                changeMap=true;
                changeMap(0);
            } else if (player.playerX > 980 && (player.playerY > 510 && player.playerY < 640) && player.getGameState() == 1) {
                changeMap=true;
                changeMap(6);
            } else if (player.playerX < 10 && (player.playerY > 510 && player.playerY < 610) && player.getGameState() == 6) {
                changeMap=true;
                changeMap(1);
            } else if (player.playerX > 980 && (player.playerY > 190 && player.playerY < 260) && player.getGameState() == 6) {
                changeMap=true;
                changeMap(7);
            } else if (player.playerX > 970 && (player.playerY > 190 && player.playerY < 260) && player.getGameState() == 7) {
                changeMap=true;
                changeMap(2);
            } else if (player.playerX < 10 && (player.playerY > 190 && player.playerY < 260) && player.getGameState() == 7) {
                changeMap=true;
                changeMap(6);
            } else if (player.playerX < 20 && (player.playerY > 120 && player.playerY < 325) && player.getGameState() == 2) {
                changeMap=true;
                changeMap(7);
            } else if ((player.playerY > 250 && player.playerY < 275) && (player.playerX > 438 && player.playerX < 456) && player.getGameState() == 0) {
                changeMap=true;
                changeMap(3);
            } else if ((player.playerY > 450 && player.playerX > 438 && player.playerX < 492) && player.getGameState() == 3) {
                changeMap=true;
                changeMap(0);
            } else if ((player.playerY < 80 && (player.playerX) > 1695 && player.playerX < 1760) && player.getGameState() == 2) {
                changeMap=true;
                changeMap(4);
            } else if ((player.playerY > 945 && (player.playerX) > 928 && player.playerX < 960) && player.getGameState() == 4) {
                changeMap=true;
                changeMap(2);
            } else if (player.playerY < 50 && (player.playerX > 90 && player.playerX < 160) && player.getGameState() == 4) {
                changeMap=true;
                changeMap(5);
                bossMusic.play(0.5);
                backgroundMusic.stop();
            } else if ((player.playerY > 550 && (player.playerX) > 380 && player.playerX < 450) && player.getGameState() == 5) {
                changeMap=true;
                changeMap(4);
                bossMusic.stop();
                backgroundMusic.play(0.5);
            }
        }
    }
    public boolean collision(int x, int y) {
        switch (tiles[y][x]) {
            case 8:
            case 80:
            case 81:
            case 112:
            case 113:
            case 114:
            case 136:
            case 137:
            case 138:
            case 144:
            case 141:
            case 146:
            case 168:
            case 165:
            case 167:
            case 164:
            case 150:
            case 151:
            case 152:
            case 153:
            case 159:
            case 160:
            case 65:
            case 66:
            case 67:
            case 40:
            case 42:
            case 41:
            case 82:
            case 83:
            case 9:
            case 10:
            case 11:
            case 12:
            case 54:
            case 231:
            case 32:
            case 233:
            case 234:
            case 181:
            case 50:
            case 85:
            case 86:
            case 188:
            case 225:
            case 227:
            case 236:
            case 237:
            case 238:
            case 239:
            case 240:
            case 241:
            case 242:
            case 258:
            case 261:
            case 263:
            case 265:
            case 268:
                return true;
            default:
                return false;
        }
    }

    public void manager() throws IOException, URISyntaxException {
        String number =  ""+(player.getGameState()+1);
        InputStream is = getClass().getResourceAsStream("/resources/maps/map" + number + ".txt");
        //File file = new File(getClass().getClassLoader().getResource("/resources/maps/map" +number+".txt").toExternalForm());
        Scanner scan = new Scanner(is);
        int counter = 0;
        while (scan.hasNextInt()) {
            counter++;
            scan.nextInt();
        }
        is = getClass().getResourceAsStream("/resources/maps/map" + number + ".txt");
        Scanner scan2 = new Scanner(is);
        boolean counted = false;
        while (scan.hasNextLine()) {
            ++rows;
            Scanner colReader = new Scanner(scan.nextLine());
            if (!counted) {
                while (colReader.hasNextInt()) {
                    ++columns;
                }
            }
            counted = true;
        }
        tiles = new int[rows][columns];
        scan.close();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (scan2.hasNextInt()) {
                    tiles[i][j] = scan2.nextInt();
                }
            }
        }
        scan2.close();
    }

    public void clearAllFXElements() {
        drawPane.getChildren().clear();
    }

    private void changeMap(int gameState) {
        int current = player.getGameState();
        int px = 0;
        int py = 0;

        switch(gameState) {
            case 0:
                if (current == 1) {
                    px = 450;
                    py = 630;
                } else if (current == 3) {
                    px = 445;
                    py = 280;
                }
                bossMusic.stop();
                setMapAndPlayer(32, 22, 1024, 704, px, py);
                break;
            case 1:
                if (current == 0) {
                    px = 450;
                    py = 20;
                } else if (current == 6) {
                    px = 960;
                    py = 560;
                }
                bossMusic.stop();
                setMapAndPlayer(32, 22, 1024, 704, px, py);
                break;
            case 2:
                if (current == 4){
                    px=1726;
                    py=90;
                } else if(current==7){
                    px=60;
                    py=220;
                }
                bossMusic.stop();
                setMapAndPlayer(70, 22, 2240, 704, px, py);
                break;
            case 3:
                if(current==0){
                    px=460;
                    py=445;
                }
                bossMusic.stop();
                setMapAndPlayer(32, 22, 1024, 704, px, py);
                break;
            case 4:
                if (current == 2){
                    px=945;
                    py=925;
                } else if(current==5){
                    px=130;
                    py=80;
                }
                bossMusic.stop();
                setMapAndPlayer(32, 32, 1024, 1024,px,py);
                break;
            case 5:
                if (current == 4){
                    px=420;
                    py=530;
                }
                backgroundMusic.stop();
                setMapAndPlayer(29, 19, 928, 608,px,py);
                break;
            case 6:
                if (current == 1){
                    px=60;
                    py=570;
                } else if(current==7){
                    px=900;
                    py=220;
                }
                bossMusic.stop();
                setMapAndPlayer(32, 22, 1024, 704,px,py);
                break;
            case 7:
                if (current == 2){
                    px=920;
                    py=220;
                } else if(current==6){
                    px=60;
                    py=220;
                }
                bossMusic.stop();
                setMapAndPlayer(32, 22, 1024, 704,px,py);
                break;
            default:
                System.out.println("Game state not found. Should never happen");
                break;
        }

        player.setGameState(gameState);
        try {
            manager();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void setMapAndPlayer(int columns, int rows, int worldSizeX, int worldSizeY, int playerX, int playerY) {
        clearAllFXElements();
        setColumns(columns);
        setRows(rows);
        setWorldSizeX(worldSizeX);
        setWorldSizeY(worldSizeY);
        player.setPlayerX(playerX);
        player.setPlayerY(playerY);
        mapArray = null;
    }
}
