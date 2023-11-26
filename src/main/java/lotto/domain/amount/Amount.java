package lotto.domain.amount;

import lotto.domain.amount.validator.AmountValidator;
import lotto.constant.Constant;

public class Amount {

    private final int amount;

    public Amount(final int amount) {
        AmountValidator.validateAmount(amount);
        this.amount = amount;
    }

    public int getCount() {
        return this.amount / Constant.PRICE_PER_LOTTO.getConstant();
    }
}
