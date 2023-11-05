package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.view.InputView;

public class LottoStore {
    public void playLotto() {
        purchaseLotto();
    }

    private void purchaseLotto() {
        String inputAmount = InputView.receivePurchaseAmount();
        PurchaseAmount purchaseAmount = new PurchaseAmount(inputAmount);
    }
}
