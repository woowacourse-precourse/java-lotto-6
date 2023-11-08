package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private String getPurchaseAmount() {
        outputView.printPurchaseAmountInputMessage();
        return inputView.readPurchaseAmount();
    }
}
