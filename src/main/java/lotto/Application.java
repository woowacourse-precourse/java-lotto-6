package lotto;

import camp.nextstep.edu.missionutils.Console;

import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
        Console.close();
    }
}

