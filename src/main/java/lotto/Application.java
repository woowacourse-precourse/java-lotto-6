package lotto;

import lotto.controller.Controller;

public class Application {
    public static void main(String[] args) {
        // Features
        Controller controller = new Controller();

        controller.startGame();
    }

}
