package lotto.domain;

import lotto.validator.PurchaseAmountValidator;

public class PurchaseAmount {
    public static final int PURCHASE_AMOUNT_UNIT = 1_000;
    private final int amount;

    public PurchaseAmount(int amount) {
        PurchaseAmountValidator.validatePurchaseAmount(amount);
        this.amount = amount;
    }

    public int purchaseQuantityLottos() {
        return amount / PURCHASE_AMOUNT_UNIT;
    }
}
