package lotto.domain.model;

import lotto.constant.IllegalArgumentExceptionType;

public final class LottoBonusNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int value;

    public LottoBonusNumber(int value) {
        validateMinRange(value);
        validateMaxRange(value);
        this.value = value;
    }

    private void validateMinRange(int value) {
        if (value < MIN_NUMBER) {
            throw IllegalArgumentExceptionType.LOTTO_RANGE_ERROR.getException();
        }
    }

    private void validateMaxRange(int value) {
        if (value > MAX_NUMBER) {
            throw IllegalArgumentExceptionType.LOTTO_RANGE_ERROR.getException();
        }
    }

    public int getValue() {
        return value;
    }
}
