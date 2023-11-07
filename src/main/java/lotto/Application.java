package lotto;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        try {
            GameController gameController = new GameController();
            gameController.start();
        } catch (IllegalArgumentException argumentException) {
            System.out.println(argumentException.getMessage());
        }
    }
}
