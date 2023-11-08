package lotto.Model;

import lotto.View.ExceptionMessages;

public class LottoPurchaseAmount {
    private final int purchaseAmount;

    public LottoPurchaseAmount(String purchaseAmount) {
        int purchaseAmountNum = validateIsNumeric(purchaseAmount);
        validateFitPurchaseAmountCondition(purchaseAmountNum);
        this.purchaseAmount = purchaseAmountNum;
    }

    public int calculatePurchaseLottoCount() {
        return purchaseAmount / 1000;
    }

    public static int validateIsNumeric(String purchaseAmount) throws IllegalArgumentException {
        try {
            return Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            ExceptionMessages.purchaseAmountTypeError();
            throw new IllegalArgumentException();
        }
    }

    public static void validateFitPurchaseAmountCondition(int purchaseAmount) {
        if (purchaseAmount <= 0 || purchaseAmount % 1000 != 0) {
            ExceptionMessages.purchaseAmountRangeError();
            throw new IllegalArgumentException();
        }
    }
}
