package lotto;

import lotto.controller.GameController;
import lotto.service.GameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameController controller = new GameController(new InputView(), new OutputView(), new GameService());
        controller.gameStart();
    }
}

