package lotto.controller;

import lotto.domain.InputPurchaseAmount;
import lotto.views.Exceptions;

public class ReadPurchaseLottoModules {

    public static boolean isPurchaseAmountInt(String purchaseAmountString) {
        try {
            InputPurchaseAmount.inputPurchaseAmountInt(purchaseAmountString);
            return false;
        } catch (IllegalArgumentException e) {
            Exceptions.exceptionNotInt();
            return true;
        }
    }

    public static boolean isPurchaseAmountPositive(int purchaseAmount) {
        try {
            InputPurchaseAmount.inputPurchaseAmountPositive(purchaseAmount);
            return false;
        } catch (IllegalArgumentException e) {
            Exceptions.execptionNotPositive();
            return true;
        }
    }

    public static boolean isPurchaseAmountDivisible1000(int purchaseAmount) {
        try {
            InputPurchaseAmount.inputPurchaseAmountDivisible1000(purchaseAmount);
            return false;
        } catch (IllegalArgumentException e) {
            Exceptions.exceptionNotDivisible1000();
            return true;
        }
    }
}
