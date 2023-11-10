package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.GameController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(), new OutputView());
        gameController.run();
        Console.close();
    }
}
