package lotto.controller;

import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printInputPurchaseAmountMessage();
    }
}
