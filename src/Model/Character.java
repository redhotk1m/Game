package Model;

import java.io.Serializable;

public class Character implements Serializable{

    public  int count = 6;
    public  int columns = 12;
    public  int offsetX = 0;
    public  int offsetY = 0;
    public  int width = 32;
    public  int height = 32;
    public static double visibleHealth;
    public static double fullWidth = 200.0;
    public int playerX;
    public int playerY;
    private int playerUserScore;
    private double playerMaxHealth;
    private double playerMaxStamina;
    private double playerActualHealth;
    private double playerSpeedModifier;
    private double playerStaminaRegenSpeed;
    private double playerPassiveHealthRegen;
    private double playerDamage;
    private int upgradeCost;
    public int gameState;

    public Character(int playerX, int playerY, int playerUserScore, double playerMaxHealth, double playerMaxStamina,
                     double playerStaminaRegenSpeed, double playerPassiveHealthRegen, double playerDamage,
                     double playerSpeedModifier, double playerActualHealth, int gameState, int upgradeCost) {
        this.playerX = playerX;
        this.playerY = playerY;
        this.playerUserScore =playerUserScore;
        this.playerMaxHealth =playerMaxHealth;
        this.playerMaxStamina =playerMaxStamina;
        this.playerStaminaRegenSpeed =playerStaminaRegenSpeed;
        this.playerDamage=playerDamage;
        this.playerPassiveHealthRegen =playerPassiveHealthRegen;
        this.playerSpeedModifier=playerSpeedModifier;
        this.playerActualHealth=playerActualHealth;
        this.gameState=gameState;
        this.upgradeCost=upgradeCost;
    }

    public int getGameState() {
        return gameState;
    }

    void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }

    public void setUpgradeCost(int upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getOffsetX() {
        return offsetX;
    }

    public void setOffsetX(int offsetX) {
        this.offsetX = offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }

    public void setOffsetY(int offsetY) {
        this.offsetY = offsetY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getPlayerActualHealth() {
        return playerActualHealth;
    }

    public void setPlayerActualHealth(double playerActualHealth) {
        this.playerActualHealth = playerActualHealth;
    }

    public double getPlayerSpeedModifier() {
        return playerSpeedModifier;
    }

    public void setPlayerSpeedModifier(double playerSpeedModifier) {
        this.playerSpeedModifier = playerSpeedModifier;
    }
    public  int getPlayerX() {
        return this.playerX;
    }

    public  void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public  int getPlayerY() {
        return this.playerY;
    }

    public  void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public  int getPlayerUserScore() {
        return this.playerUserScore;
    }

    public  void setPlayerUserScore(int playerUserScore) {
        this.playerUserScore = playerUserScore;
    }

    public  double getPlayerMaxHealth() {
        return this.playerMaxHealth;
    }

    public  void setPlayerMaxHealth(double playerMaxHealth) {
        this.playerMaxHealth = playerMaxHealth;
    }

    public  double getPlayerMaxStamina() {
        return this.playerMaxStamina;
    }

    public void setPlayerMaxStamina(double playerMaxStamina) {
        this.playerMaxStamina = playerMaxStamina;
    }

    public  double getPlayerStaminaRegenSpeed() {
        return this.playerStaminaRegenSpeed;
    }

    public  void setPlayerStaminaRegenSpeed(double playerStaminaRegenSpeed) {
        this.playerStaminaRegenSpeed = playerStaminaRegenSpeed;
    }

    public  double getPlayerPassiveHealthRegen() {
        return this.playerPassiveHealthRegen;
    }

    public  void setPlayerPassiveHealthRegen(double playerPassiveHealthRegen) {
        this.playerPassiveHealthRegen = playerPassiveHealthRegen;
    }

    public  double getPlayerDamage() {
        return this.playerDamage;
    }

    public  void setPlayerDamage(double playerDamage) {
        this.playerDamage = playerDamage;
    }


}


