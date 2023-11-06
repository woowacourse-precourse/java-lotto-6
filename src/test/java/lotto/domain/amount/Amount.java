package lotto.domain.amount;

import lotto.domain.amount.validator.AmountValidator;

public class Amount {

    private final int amount;

    public Amount(final int amount) {
        AmountValidator.validateAmount(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }
}
