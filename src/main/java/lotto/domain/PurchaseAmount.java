package lotto.domain;

import static lotto.exception.ExceptionMessage.PURCHASE_AMOUNT_HAS_REMAINDER;

import lotto.exception.LottoGameException;

public class PurchaseAmount {

    public static final int MIN_PURCHASE_AMOUNT = 1000;
    public static final int ZERO_AMOUNT = 0;
    public static final int NO_REMAINDER = 0;
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if (isZeroAmount(purchaseAmount) || hasRemainder(purchaseAmount)) {
            throw new LottoGameException(String.format(PURCHASE_AMOUNT_HAS_REMAINDER.getMessage(), purchaseAmount));
        }
    }

    private static boolean isZeroAmount(int purchaseAmount) {
        return purchaseAmount == ZERO_AMOUNT;
    }

    private boolean hasRemainder(int purchaseAmount) {
        return purchaseAmount % MIN_PURCHASE_AMOUNT != NO_REMAINDER;
    }

    public int getAvailablePurchase() {
        return this.purchaseAmount / MIN_PURCHASE_AMOUNT;
    }
}
