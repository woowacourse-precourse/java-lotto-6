package lotto.domain;

import lotto.config.LottoConfig;
import lotto.exception.Errors;

public class Money {
    private final long value;

    public Money(final long value) {
        validateMoney(value);
        this.value = value;
    }

    private void validateMoney(long value) {
        if (value > LottoConfig.MAXIMUM_PURCHASE_LIMIT) {
            throw Errors.GREATER_THAN_MAXIMUM_PURCHASE_LIMIT.getException();
        }
        if (value < LottoConfig.PRICE) {
            throw Errors.INVALID_MONEY.getException();
        }
        if (value % LottoConfig.PRICE != 0) {
            throw Errors.NOT_DIVISIBLE_BY_PRICE.getException();
        }
    }

    public long getValue() {
        return value;
    }
}
