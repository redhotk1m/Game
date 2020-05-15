package Model;

public class ImportantValues{

    private static double WORLD_SIZE_X = 1024;
    private static double WORLD_SIZE_Y = 700;
    private static double VIEWPORT_SIZE_X=900;
    private static double VIEWPORT_SIZE_Y=600;

    public static double getWorldSizeX() {
        return WORLD_SIZE_X;
    }

    public static void setWorldSizeX(double worldSizeX) {
        WORLD_SIZE_X = worldSizeX;
    }

    public static double getWorldSizeY() {
        return WORLD_SIZE_Y;
    }

    public static void setWorldSizeY(double worldSizeY) {
        WORLD_SIZE_Y = worldSizeY;
    }

    public static double getViewportSizeX() {
        return VIEWPORT_SIZE_X;
    }

    public static void setViewportSizeX(double viewportSizeX) {
        VIEWPORT_SIZE_X = viewportSizeX;
    }

    public static double getViewportSizeY() {
        return VIEWPORT_SIZE_Y;
    }

    public static void setViewportSizeY(double viewportSizeY) {
        VIEWPORT_SIZE_Y = viewportSizeY;
    }

}
