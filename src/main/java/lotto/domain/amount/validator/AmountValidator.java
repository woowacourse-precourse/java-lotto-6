package lotto.domain.amount.validator;

import lotto.constant.Constant;
import lotto.exception.custom.CustomIllegalStateAmountException;
import lotto.exception.amount.AmountExceptionStatus;

public class AmountValidator {

    private static final AmountValidator AMOUNT_VALIDATOR = new AmountValidator();

    private AmountValidator() {
    }

    public static void validateAmount(final int amount) {
        AMOUNT_VALIDATOR.validateAmountIsPositive(amount);
        AMOUNT_VALIDATOR.validateAmountIsOutOfRange(amount);
        AMOUNT_VALIDATOR.validateAmountIsAvailable(amount);
    }

    private void validateAmountIsPositive(final int amount) {
        if (!isPositive(amount)) {
            throw new CustomIllegalStateAmountException(AmountExceptionStatus.AMOUNT_IS_NOT_POSITIVE);
        }
    }

    private boolean isPositive(final int amount) {
        return Constant.ZERO.getConstant() < amount;
    }

    private void validateAmountIsOutOfRange(final int amount) {
        if (isOutOfRange(amount)) {
            throw new CustomIllegalStateAmountException(AmountExceptionStatus.AMOUNT_IS_OUT_OF_RANGE);
        }
    }

    private boolean isOutOfRange(final int amount) {
        return Constant.ALLOWED_MAXIMUM_AMOUNT.getConstant() < amount;
    }

    private void validateAmountIsAvailable(final int amount) {
        if (!isAvailable(amount)) {
            throw new CustomIllegalStateAmountException(AmountExceptionStatus.AMOUNT_IS_NOT_AVAILABLE);
        }
    }

    private boolean isAvailable(final int amount) {
        return amount % Constant.PRICE_PER_LOTTO.getConstant()
                == Constant.ZERO.getConstant();
    }
}
