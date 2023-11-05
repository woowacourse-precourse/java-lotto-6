package lotto.controller;

import lotto.domain.inputPurchaseAmount;
import lotto.views.InputViews;
import lotto.views.Exceptions;

public class LottoController {
    public void run() {
        while (readPurchaseLotto()) {
        }
    }

    public boolean readPurchaseLotto() {
        String purchaseAmount = InputViews.readPurchaseAmount();
        try {
            inputPurchaseAmount.inputPurchaseAmountInt(purchaseAmount);
            return false;
        } catch (IllegalArgumentException e) {
            Exceptions.exceptionNotInt();
            return true;
        }
    }
}
