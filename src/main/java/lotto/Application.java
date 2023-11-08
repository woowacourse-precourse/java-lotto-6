package lotto;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            GameController gameController = new GameController();
            gameController.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
