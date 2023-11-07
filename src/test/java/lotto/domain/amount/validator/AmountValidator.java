package lotto.domain.amount.validator;

import lotto.constant.Constant;
import lotto.constant.errorMessage.amount.AmountExceptionStatus;
import lotto.constant.errorMessage.amount.IllegalStateAmountException;

public class AmountValidator {

    private static final AmountValidator AMOUNT_VALIDATOR = new AmountValidator();

    private AmountValidator() {
    }

    public static void validateAmount(final int amount) {
        AMOUNT_VALIDATOR.validateAmountIsPositive(amount);
        AMOUNT_VALIDATOR.validateAmountIsAbove(amount);
        AMOUNT_VALIDATOR.validateAmountIsDivisible(amount);
    }

    private void validateAmountIsPositive(final int amount) {
        if (!isPositive(amount)) {
            throw new IllegalStateAmountException(AmountExceptionStatus.AMOUNT_IS_NOT_POSITIVE);
        }
    }

    private boolean isPositive(final int amount) {
        return amount > Constant.ZERO_VALUE;
    }

    private void validateAmountIsAbove(final int amount) {
        if (!isAbove(amount)) {
            throw new IllegalStateAmountException(AmountExceptionStatus.AMOUNT_IS_NOT_ABOVE);
        }
    }

    private boolean isAbove(final int amount) {
        return amount >= Constant.ALLOWED_MINIMUM_AMOUNT_VALUE;
    }

    private void validateAmountIsDivisible(final int amount) {
        if (!isDivisible(amount)) {
            throw new IllegalStateAmountException(AmountExceptionStatus.AMOUNT_IS_NOT_DIVISIBLE);
        }
    }

    private boolean isDivisible(final int amount) {
        return amount % Constant.ALLOWED_MINIMUM_AMOUNT_VALUE == Constant.ZERO_VALUE;
    }
}
