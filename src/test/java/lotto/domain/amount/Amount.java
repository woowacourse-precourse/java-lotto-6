package lotto.domain.amount;

import lotto.constant.Constant;
import lotto.domain.amount.validator.AmountValidator;

public record Amount(int amount) {

    public Amount {
        AmountValidator.validateAmount(amount);
    }

    public int getDividedAmount() {
        return this.amount / Constant.ALLOWED_MINIMUM_AMOUNT_VALUE;
    }
}
