package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        String purchaseAmount = getPurchaseAmount();

    }

    private String getPurchaseAmount() {
        OutputView.printEnterPurchaseAmount();
        return InputView.getInputPurchaseAmount();
    }
}
