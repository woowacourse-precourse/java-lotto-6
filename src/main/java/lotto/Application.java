package lotto;

import lotto.controller.GameConfiguration;
import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameConfiguration gameConfiguration = new GameConfiguration();
        GameController gameController = gameConfiguration.gameController();
        gameController.startGame();
    }
}
