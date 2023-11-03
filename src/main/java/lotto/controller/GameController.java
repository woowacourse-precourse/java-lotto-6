package lotto.controller;

public class GameController {

    private static GameController gameController;

    private GameController() {}

    public GameController getInstance() {
        if (gameController == null) {
            gameController = new GameController();
        }
        return gameController;
    }
}
