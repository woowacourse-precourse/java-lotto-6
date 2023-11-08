package lotto;

import lotto.controller.GameController;
import lotto.controller.InputController;

import lotto.domain.model.Money;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputController(),new OutputView());
        gameController.startGame();
        gameController.showResult();
    }
}
