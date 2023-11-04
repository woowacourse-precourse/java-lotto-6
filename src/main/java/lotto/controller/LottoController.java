package lotto.controller;

import lotto.io.OutputView;

public class LottoController {

    private final OutputView outputView;

    public LottoController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        outputView.printPurchaseAmountRequset();
    }
}
