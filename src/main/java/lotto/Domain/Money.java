package lotto.Domain;

import lotto.Exception.MoneyErrorMessage;

public class Money {
    private int purchaseAmount;

    public Money(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(MoneyErrorMessage.INVALID_AMOUNT_NOT_STANDARD_UNIT.getMessage());
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
