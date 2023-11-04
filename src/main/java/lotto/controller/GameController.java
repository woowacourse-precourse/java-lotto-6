package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(
            InputView inputView,
            OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

}
