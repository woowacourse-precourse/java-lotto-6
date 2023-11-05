package lotto.model;

import static lotto.util.Constants.LOTTO_PRICE;

import lotto.validator.PurchaseAmountValidator;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        PurchaseAmountValidator.validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public boolean notFullyIssued(int count) {
        return purchaseAmount / LOTTO_PRICE != count;
    }

}
