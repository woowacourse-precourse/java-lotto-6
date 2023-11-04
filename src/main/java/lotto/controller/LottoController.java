package lotto.controller;

import lotto.io.InputView;
import lotto.io.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        outputView.printPurchaseAmountRequset();
        inputView.readPurchaseAmount();
    }
}
