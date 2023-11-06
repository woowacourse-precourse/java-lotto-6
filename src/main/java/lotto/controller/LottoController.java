package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class LottoController {
    public void playLotto() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        try {
            String inputAmount = InputView.receivePurchaseAmount();
            PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            purchaseLotto();
        }
    }
}
