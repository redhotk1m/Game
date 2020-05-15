package Model;

public class Enemy{

    public static int offsetX = 0;
    public static int offsetY = 0;
    public static int width = 32;
    public static int height = 32;
    public static int count = 3;
    public static int columns = 12;
    public int x;
    public int y;
    private int value;
    private final int birthPlaceX;
    private final int birthPlaceY;
    private int enemyHealth;
    public boolean enemyStunned;
    private int enemyDamage;
    public boolean isAggroed;

    Enemy(int x, int y, int enemyHealth, int enemyDamage, int birthPlaceX,
                 int birthPlaceY, boolean isAggroed, int value){
        this.x=x;
        this.y=y;
        this.enemyHealth=enemyHealth;
        this.enemyDamage=enemyDamage;
        this.birthPlaceX=birthPlaceX;
        this.birthPlaceY=birthPlaceY;
        this.isAggroed=isAggroed;
        this.value=value;
        enemyStunned = false;
    }

    public static int getOffsetY() {
        return offsetY;
    }

    public static void setOffsetY(int offsetY) {
        Enemy.offsetY = offsetY;
    }

    public boolean isAggroed() {
        return isAggroed;
    }

    public void setAggroed(boolean aggroed) {
        isAggroed = aggroed;
    }

    public boolean isEnemyStunned() {
        return enemyStunned;
    }

    public void setEnemyStunned(boolean enemyStunned) {
        this.enemyStunned = enemyStunned;
    }

    public  int getEnemyHealth() {
        return enemyHealth;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public  int getEnemyDamage() {
        return enemyDamage;
    }

    public  void setEnemyDamage(int enemyDamage) {
        this.enemyDamage = enemyDamage;
    }

    public int getX() {
        return this.x;
    }

    public  void setX(int x) {
        this.x = x;
    }

    public  int getY() {
        return y;
    }

    public  void setY(int y) {
        this.y = y;
    }

    int getBirthPlaceX() {
        return birthPlaceX;
    }

    int getBirthPlaceY() {
        return birthPlaceY;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
