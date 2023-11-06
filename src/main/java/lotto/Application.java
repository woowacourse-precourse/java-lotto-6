package lotto;

import lotto.controller.GameController;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        GameController gameController = GameController.getInstance(inputView);

        gameController.startGame();
    }
}
