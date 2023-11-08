package lotto;

import lotto.controller.GameController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController gameController = new GameController(new InputView(), new OutputView());

        gameController.run();
    }
}
