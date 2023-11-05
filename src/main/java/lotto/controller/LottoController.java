package lotto.controller;

import lotto.domain.inputPurchaseAmount;
import lotto.views.InputViews;
import lotto.views.Exceptions;

public class LottoController {
    int purchaseAmount;
    public void run() {
        while (readPurchaseLotto()) {
        }
    }

    public boolean readPurchaseLotto() {
        String purchaseAmountString = InputViews.readPurchaseAmount();
        if (isPurchaseAmountInt(purchaseAmountString)) {
            return true;
        }

        purchaseAmount = Integer.parseInt(purchaseAmountString);
        if (isPurchaseAmountPositive()) {
            return true;
        }
        if (isPurchaseAmountDivisible1000()) {
            return true;
        }
        return false;
    }

    public boolean isPurchaseAmountInt(String purchaseAmountString) {
        try {
            inputPurchaseAmount.inputPurchaseAmountInt(purchaseAmountString);
            return false;
        } catch (IllegalArgumentException e) {
            Exceptions.exceptionNotInt();
            return true;
        }
    }

    public boolean isPurchaseAmountPositive() {
        try {
            inputPurchaseAmount.inputPurchaseAmountPositive(purchaseAmount);
            return false;
        } catch (IllegalArgumentException e) {
            Exceptions.execptionNotPositive();
            return true;
        }
    }

    public boolean isPurchaseAmountDivisible1000() {
        try {
            inputPurchaseAmount.inputPurchaseAmountDivisible1000(purchaseAmount);
            return false;
        } catch (IllegalArgumentException e) {
            Exceptions.exceptionNotDivisible1000();
            return true;
        }
    }
}
