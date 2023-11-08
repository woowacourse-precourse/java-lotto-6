package lotto;


import lotto.controller.GameController;
import lotto.utils.RandomNumbersGenerator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.play();
    }
}
