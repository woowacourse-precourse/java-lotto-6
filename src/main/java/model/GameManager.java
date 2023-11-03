package model;

public class GameManager {

    private GameManager() {

    }

    public static GameManager createDefault(final int lottoCount) {
        return new GameManager();
    }
}
