package lotto;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        DependencyConfig dependencyConfig = new DependencyConfig();
        GameController gameController = dependencyConfig.gameController();
        gameController.gameStart();
    }
}
