package Controllerpackage;

import javafx.scene.media.AudioClip;

public class SoundController {

    static AudioClip coinPickup = new AudioClip(SoundController.class.getResource("/resources/sounds/coinPickup.wav").toString());
    static AudioClip healthPickup = new AudioClip(SoundController.class.getResource("/resources/sounds/healthPickup.wav").toString());
    public static AudioClip backgroundMusic = new AudioClip(SoundController.class.getResource("/resources/sounds/backgroundMusic.wav").toString());
    static AudioClip lowHealth = new AudioClip(SoundController.class.getResource("/resources/sounds/lowHealthTest.wav").toString());
    static AudioClip introSong = new AudioClip(SoundController.class.getResource("/resources/sounds/introSong.wav").toString());
    static AudioClip youDiedSound = new AudioClip(SoundController.class.getResource("/resources/sounds/youDiedSound.mp3").toString());
    static AudioClip buttonUpgrade = new AudioClip(SoundController.class.getResource("/resources/sounds/buttonUpgrade.wav").toString());
    static AudioClip exitButtonSound = new AudioClip(SoundController.class.getResource("/resources/sounds/exitButtonSound.wav").toString());
    static AudioClip savedGameSound = new AudioClip(SoundController.class.getResource("/resources/sounds/savedGameSound.wav").toString());
    static AudioClip buttonMouseoverSound = new AudioClip(SoundController.class.getResource("/resources/sounds/buttonMouseoverSound.wav").toString());
    static AudioClip buttonPress = new AudioClip(SoundController.class.getResource("/resources/sounds/buttonPress.wav").toString());
    static AudioClip hitPlayer = new AudioClip(SoundController.class.getResource("/resources/sounds/hitPlayer.wav").toString());
    static AudioClip attackSound = new AudioClip(SoundController.class.getResource("/resources/sounds/attackSound.mp3").toString());
    static AudioClip hitEnemy = new AudioClip(SoundController.class.getResource("/resources/sounds/hitEnemy.wav").toString());
    static AudioClip enemyDies = new AudioClip(SoundController.class.getResource("/resources/sounds/enemyDies.wav").toString());
    public static AudioClip bossMusic = new AudioClip(SoundController.class.getResource("/resources/sounds/bossMusic.wav").toString());
    static AudioClip storyBackground = new AudioClip(SoundController.class.getResource("/resources/sounds/storyBackground.wav").toString());
    static AudioClip storyTelling = new AudioClip(SoundController.class.getResource("/resources/sounds/storyTelling.mp3").toString());
    static AudioClip victorySound = new AudioClip(SoundController.class.getResource("/resources/sounds/victorySound.mp3").toString());
}
