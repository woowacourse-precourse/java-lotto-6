package lotto.domain.amount.validator;

import lotto.constant.errorMessage.amount.AmountExceptionStatus;
import lotto.constant.errorMessage.amount.IllegalStateAmountException;

public class AmountValidator {

    private static final AmountValidator AMOUNT_VALIDATOR = new AmountValidator();
    private static final int ALLOWED_MIN_AMOUNT_VALUE = 1000;
    private static final int ZERO_VALUE = 0;

    private AmountValidator() {
    }

    public static void validateAmount(final int amount) {
        AMOUNT_VALIDATOR.validateAmountIsPositive(amount);
        AMOUNT_VALIDATOR.validateAmountIsDivisible(amount);
        // 1000 보다 큰 수 와야
    }

    private void validateAmountIsPositive(final int amount) {
        if (!isPositive(amount)) {
            throw new IllegalStateAmountException(AmountExceptionStatus.AMOUNT_IS_NOT_POSITIVE);
        }
    }

    private boolean isPositive(final int amount) {
        return amount > ZERO_VALUE;
    }

    private void validateAmountIsDivisible(final int amount) {
        if (!isDivisible(amount)) {
            throw new IllegalStateAmountException(AmountExceptionStatus.AMOUNT_IS_NOT_DIVISIBLE);
        }
    }

    private boolean isDivisible(final int amount) {
        return amount % ALLOWED_MIN_AMOUNT_VALUE == ZERO_VALUE;
    }
}
