package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    InputView inputView;
    OutputView outputView;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
}
