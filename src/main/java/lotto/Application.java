package lotto;

import lotto.controller.GameController;
import lotto.controller.InputController;

import lotto.domain.service.Money;
import lotto.domain.service.User;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputController(new Money()),new OutputView(),new User(),new Money());
        gameController.startGame();
        gameController.showResult();
    }
}
