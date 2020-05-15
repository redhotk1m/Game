package Model;

public class Coin {

    public static int offsetX = 0;
    public static int offsetY = 0;
    public static int width = 32;
    public static int height = 32;
    public static int count = 1;
    public static int columns = 1;
    public int x;
    public int y;
    private int value;

    public Coin(int x, int y,int value){
        this.x=x;
        this.y=y;
        this.value=value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }



}
