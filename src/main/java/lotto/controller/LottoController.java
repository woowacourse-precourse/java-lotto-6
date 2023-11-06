package lotto.controller;

import lotto.view.InputView;

public class LottoController {
    public void run() {
        int purchaseAmount = InputView.inputPurchaseAmount();
        System.out.println(purchaseAmount);
    }
}
