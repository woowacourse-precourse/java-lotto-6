package lotto.domain;

import lotto.exception.purchaseamount.PurchaseAmountDivideException;
import lotto.exception.purchaseamount.PurchaseAmountLimitException;

public class PurchaseAmount {

    private static final int LOTTO_PRICE = 1000;
    private static final int DIVIDE_UP_VALUE = 0;
    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        validatePurchaseAmountUnderThousand(purchaseAmount);
        validatePurchaseAmountDivideByThousand(purchaseAmount);
    }

    private void validatePurchaseAmountDivideByThousand(int purchaseAmount) {
        if(purchaseAmount % LOTTO_PRICE != DIVIDE_UP_VALUE) {
            throw new PurchaseAmountDivideException();
        }
    }

    private void validatePurchaseAmountUnderThousand(int purchaseAmount) {
        if(purchaseAmount < LOTTO_PRICE) {
            throw new PurchaseAmountLimitException();
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
