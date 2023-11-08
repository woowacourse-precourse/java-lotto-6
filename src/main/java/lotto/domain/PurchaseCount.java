package lotto.domain;


import static lotto.controller.constants.ErrorMessage.INVALID_PURCHASE_AMOUNT;

public class PurchaseCount {
    private final int value;

    public PurchaseCount(int purchaseAmount) {
        validate(purchaseAmount);
        this.value = purchaseAmount/1000;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    public int getValue() {
        return value;
    }
}