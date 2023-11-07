package lotto.domain.amount.validator;

import lotto.constant.errorMessage.amount.AmountExceptionStatus;
import lotto.constant.errorMessage.amount.IllegalStateAmountException;

public class AmountValidator {

    private static final AmountValidator AMOUNT_VALIDATOR = new AmountValidator();

    private AmountValidator() {
    }

    public static void validateAmount(final int amount) {
        AMOUNT_VALIDATOR.validateAmountIsPositive(amount);
        AMOUNT_VALIDATOR.validateAmountIsDivisible(amount);
        // 1000 보다 큰 수 와야함
    }

    private void validateAmountIsPositive(final int amount) {
        if (!isPositive(amount)) {
            throw new IllegalStateAmountException(AmountExceptionStatus.AMOUNT_IS_NOT_POSITIVE);
        }
    }

    private boolean isPositive(final int amount) {
        return amount > 0;
    }

    private void validateAmountIsDivisible(final int amount) {
        if (!isDivisible(amount)) {
            throw new IllegalStateAmountException(AmountExceptionStatus.AMOUNT_IS_NOT_DIVISIBLE);
        }
    }

    private boolean isDivisible(final int amount) {
        return amount % 1000 == 0;
    }
}
