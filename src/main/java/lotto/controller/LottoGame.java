package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private InputView inputView;
    private OutputView outputView;

    public LottoGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}
