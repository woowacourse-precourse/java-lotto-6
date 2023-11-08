package lotto;

import lotto.controller.GameController;
import lotto.service.NumberService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(), new OutputView(), new NumberService());
        gameController.run();
    }
}
