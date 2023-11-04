package lotto.domain;

import lotto.view.ErrorMessage;

public class Buyer {
    private static final int PURCHASE_AMOUNT_UNIT = 1000;
    private final int purchaseAmount;

    private Buyer(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static Buyer from(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        return new Buyer(purchaseAmount);
    }

    private static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            ErrorMessage.divideNumberError(PURCHASE_AMOUNT_UNIT);
            throw new IllegalArgumentException();
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
