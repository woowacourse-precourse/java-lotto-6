package lotto.model;

import lotto.validation.PurchaseAmountValidator;

public class PurchaseAmount {

    private int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
    }

    private void validate(int amount) {
        PurchaseAmountValidator.validate(amount);
    }
}
