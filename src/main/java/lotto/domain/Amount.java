package lotto.domain;

import lotto.utils.Validation;

public class Amount {

    private final int amount;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        Validation.validatePurchaseAmount(amount);
    }

    public int getAmount() {
        return amount;
    }
}
