package lotto;

import lotto.presntation.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startGame();
        gameController.showResult();
    }
}
