package lotto;

import lotto.controller.GameManageController;

public class Application {
    public static void main(String[] args) {
        GameManageController game = new GameManageController();
        game.start();
    }
}
