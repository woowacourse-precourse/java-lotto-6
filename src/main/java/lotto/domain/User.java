package lotto.domain;

import lotto.utils.Validation;

public class User {
    private final int purchaseAmount;

    public User(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        Validation.validateNumberMultipleOf(purchaseAmount, 1_000);
        Validation.validateNumberInRange(purchaseAmount, 1_000, 100_000);
    }
}
