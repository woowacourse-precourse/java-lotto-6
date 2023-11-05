package lotto.controller;

import lotto.views.InputViews;

public class LottoController {
    int purchaseAmount;
    public void run() {
        while (readPurchaseLotto()) {
        }
    }

    public boolean readPurchaseLotto() {
        String purchaseAmountString = InputViews.readPurchaseAmount();
        if (readPurchaseLottoModules.isPurchaseAmountInt(purchaseAmountString)) {
            return true;
        }

        purchaseAmount = Integer.parseInt(purchaseAmountString);
        if (readPurchaseLottoModules.isPurchaseAmountPositive(purchaseAmount)) {
            return true;
        }
        if (readPurchaseLottoModules.isPurchaseAmountDivisible1000(purchaseAmount)) {
            return true;
        }
        return false;
    }
}
