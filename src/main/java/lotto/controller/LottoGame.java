package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final OutputView outputView;

    public LottoGame(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        outputView.askForPurchaseAmount();
    }
}
