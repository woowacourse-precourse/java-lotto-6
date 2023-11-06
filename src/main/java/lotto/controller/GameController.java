package lotto.controller;

import lotto.view.InputView;

public class GameController {

    private static GameController gameController;

    private GameController(InputView inputView) {}

    public static GameController getInstance(InputView inputView) {
        if (gameController == null) {
            gameController = new GameController(inputView);
        }
        return gameController;
    }

    public void startGame() {

    }
}
