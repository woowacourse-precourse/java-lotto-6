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
            throw Errors.INVALID_LIMIT.getLottoException();
        }
        if (value < LottoConfig.PRICE) {
            throw Errors.INVALID_MONEY.getLottoException();
        }
        if (value % LottoConfig.PRICE != 0) {
            throw Errors.INVALID_UNDIVISIABLE.getLottoException();
        }
    }

    public long getValue() {
        return value;
    }
}
