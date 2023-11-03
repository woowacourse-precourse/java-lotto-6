package lotto.controller;

public class GameController {

    private static GameController gameController;

    private GameController() {}

    public static GameController getInstance() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }

    public void startGame() {

    }
}
