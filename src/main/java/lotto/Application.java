package lotto;

import lotto.controller.GameController;
import lotto.validator.Error;

public class Application {
    public static void main(String[] args) {
        try {
            GameController gameController = new GameController();
            gameController.start();
        } catch (IllegalArgumentException e) {
            Error.printError(e.getMessage());
        }
    }
}
