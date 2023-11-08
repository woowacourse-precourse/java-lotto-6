package lotto.domain;

import lotto.config.LottoConfig;
import lotto.exception.Errors;

public class Money {
    private final long budget;

    public Money(final long budget) {
        validateMoney(budget);
        this.budget = budget;
    }

    private void validateMoney(long value) {
        if (value > LottoConfig.MAXIMUM_PURCHASE_LIMIT) {
            throw Errors.INVALID_LIMIT.getLottoException();
        }
        if (value < LottoConfig.PRICE) {
            throw Errors.INVALID_MONEY.getLottoException();
        }
        if (value % LottoConfig.PRICE != 0) {
            throw Errors.INVALID_INDIVISIBLE.getLottoException();
        }
    }

    public long getBudget() {
        return budget;
    }
}
