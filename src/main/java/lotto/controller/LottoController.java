package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();

    int purchaseAmount;

    public void startLotto() {
        requestPurchaseAmount();
    }

    public void requestPurchaseAmount() {
        OutputView.printPurchaseAmountRequest();
        try {
            purchaseAmount = inputView.inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            requestPurchaseAmount();
        }
    }
}