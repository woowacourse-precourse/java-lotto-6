package lotto;

import lotto.config.GameConfig;

public class Application {

    public static void main(String[] args) {
        GameManager gameManager = GameConfig.buildGameManager();
        gameManager.runGame();
    }
}
