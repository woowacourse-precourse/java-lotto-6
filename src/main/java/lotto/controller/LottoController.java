package lotto.controller;

import lotto.view.OutputView;

public class LottoController {
    OutputView outputView = new OutputView();

    public void run() {
        outputView.printPurchaseAmountInputMessage();
    }
}
