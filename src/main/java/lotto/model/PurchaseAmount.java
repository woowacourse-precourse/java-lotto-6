package lotto.model;

import lotto.validator.PurchaseAmountValidator;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        PurchaseAmountValidator.validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public boolean notFullyIssued(int count) {
        return purchaseAmount / LOTTO_PRICE != count;
    }

}
