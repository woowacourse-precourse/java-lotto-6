package lotto;

import lotto.config.GameConfig;
import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {

        GameController gameController = GameConfig.getGameController();

        gameController.start();
    }
}
