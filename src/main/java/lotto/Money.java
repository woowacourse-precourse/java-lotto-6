package lotto;

import lotto.exception.money.MoneyPositiveException;

public class Money {
    public static final int MIN_BOUND = 0;
    private final int value;

    public Money(int value) {
        validateMoneyPositive(value);
        this.value = value;
    }

    private static void validateMoneyPositive(int value) {
        if (!hasOverZeroValue(value)) {
            throw new MoneyPositiveException();
        }
    }

    private static boolean hasOverZeroValue(int value) {
        return value > MIN_BOUND;
    }

    public boolean isGreaterEqual(int target) {
        return this.value >= target;
    }

    public boolean isMultipleOf(int target) {
        return this.value % target == 0;
    }
}
