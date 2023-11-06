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
        if (value < LottoConfig.PRICE) {
            throw Errors.INVALID_MONEY.getException();
        }
    }

    public long getValue() {
        return value;
    }
}
