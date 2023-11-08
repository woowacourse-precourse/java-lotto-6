package lotto.domain;

import static lotto.domain.enums.NumberConstant.MINIMUM_LOTTO_PRICE;
import static lotto.domain.enums.NumberConstant.NO_REMAINDER;
import static lotto.domain.enums.NumberConstant.ZERO_AMOUNT;
import static lotto.exception.ExceptionMessage.PURCHASE_AMOUNT_HAS_REMAINDER;

public class PurchaseAmount {

    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if (isZeroAmount(purchaseAmount) || hasRemainder(purchaseAmount)) {
            throw new IllegalArgumentException(
                    String.format(PURCHASE_AMOUNT_HAS_REMAINDER.getMessage(), purchaseAmount));
        }
    }

    private static boolean isZeroAmount(int purchaseAmount) {
        return purchaseAmount == ZERO_AMOUNT.getValue();
    }

    private boolean hasRemainder(int purchaseAmount) {
        return purchaseAmount % MINIMUM_LOTTO_PRICE.getValue() != NO_REMAINDER.getValue();
    }

    public int getAvailablePurchaseCounts() {
        return this.purchaseAmount / MINIMUM_LOTTO_PRICE.getValue();
    }

    public int getPurchaseAmount() {
        return this.purchaseAmount;
    }
}
