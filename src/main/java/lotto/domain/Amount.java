package lotto.domain;

import lotto.validation.AmountException;

public class Amount {
    private static final int MAX_LOTTO_PRICE = 100_000;
    private static final int ONE_LOTTO_PRICE = 1_000;
    private static final int PERCENTAGE = 100;

    private final int value;

    public Amount(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        isLessThanEqualMostValue(value);
        isGreaterThanEqualLeastValue(value);
        isMultiple(value);
    }

    private void isLessThanEqualMostValue(int value) {
        if (value > MAX_LOTTO_PRICE) {
            throw AmountException.MOST_VALUE_EXCEPTION.getException();
        }
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
        return ((double) totalPrize / value) * PERCENTAGE;
    }
}
