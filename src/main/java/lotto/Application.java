package lotto;

import lotto.controller.GameController;
import lotto.controller.InputController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputController inputController = new InputController();
        GameController gameController = new GameController(inputController);
        gameController.startGame();
    }
}
