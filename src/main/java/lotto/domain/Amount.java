package lotto.domain;

import lotto.validation.AmountException;

public class Amount {
    private static final int ONE_LOTTO_PRICE = 1_000;

    private int value;

    public Amount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        isGreaterThanEqualLeastValue(value);
        isMultiple(value);
    }

    private void isGreaterThanEqualLeastValue(int value) {
        if (value < ONE_LOTTO_PRICE) {
            throw AmountException.LEAST_VALUE_EXCEPTION.getException();
        }
    }

    private void isMultiple(int value) {
        if (value % ONE_LOTTO_PRICE != 0) {
            throw AmountException.UNIT_EXCEPTION.getException();
        }
    }

    public int getLottoCount() {
        return value / ONE_LOTTO_PRICE;
    }

    public double getBenefitRate(long totalPrize) {
        return ((double) totalPrize / value) * 100;
    }
}
