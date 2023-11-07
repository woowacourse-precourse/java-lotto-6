package lotto;

import lotto.exception.money.MoneyPositiveException;
import lotto.exception.money.NonPositiveTargetException;

public class Money {
    public static final int MIN_BOUND = 0;
    private final int value;

    public Money(int value) {
        validateMoneyPositive(value);
        this.value = value;
    }

    private void validateMoneyPositive(int value) {
        if (!hasGreaterEqualZeroValue(value)) {
            throw new MoneyPositiveException();
        }
    }

    private boolean hasGreaterEqualZeroValue(int value) {
        return value >= MIN_BOUND;
    }

    public boolean isGreaterEqual(int target) {
        return this.value >= target;
    }

    public boolean isMultipleOf(int target) {
        validateTargetPositive(target);
        return this.value % target == 0;
    }

    public int divide(int target) {
        validateTargetPositive(target);
        return this.value / target;
    }

    private void validateTargetPositive(int target) {
        if (!hasGreaterZeroValue(target)) {
            throw new NonPositiveTargetException();
        }
    }

    private boolean hasGreaterZeroValue(int target) {
        return target > MIN_BOUND;
    }
}
