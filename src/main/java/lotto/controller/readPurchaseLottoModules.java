package lotto.controller;

import lotto.domain.inputPurchaseAmount;
import lotto.views.Exceptions;

public class readPurchaseLottoModules {

    public static boolean isPurchaseAmountInt(String purchaseAmountString) {
        try {
            inputPurchaseAmount.inputPurchaseAmountInt(purchaseAmountString);
            return false;
        } catch (IllegalArgumentException e) {
            Exceptions.exceptionNotInt();
            return true;
        }
    }

    public static boolean isPurchaseAmountPositive(int purchaseAmount) {
        try {
            inputPurchaseAmount.inputPurchaseAmountPositive(purchaseAmount);
            return false;
        } catch (IllegalArgumentException e) {
            Exceptions.execptionNotPositive();
            return true;
        }
    }

    public static boolean isPurchaseAmountDivisible1000(int purchaseAmount) {
        try {
            inputPurchaseAmount.inputPurchaseAmountDivisible1000(purchaseAmount);
            return false;
        } catch (IllegalArgumentException e) {
            Exceptions.exceptionNotDivisible1000();
            return true;
        }
    }
}
