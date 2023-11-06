package lotto.domain.amount;

import lotto.util.ValidationUtils;

public class Amount {

    protected final int amount;

    protected Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    protected void validate(int amount) {
        ValidationUtils.validateNotNull(amount);
    }
}
