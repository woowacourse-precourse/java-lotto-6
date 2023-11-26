package lotto.view.input.validator;

import lotto.exception.amount.AmountExceptionStatus;
import lotto.exception.custom.CustomNullPointAmountException;
import lotto.exception.custom.CustomNumberFormatAmountException;

public class ReadAmountValidator {

    static final ReadAmountValidator READ_AMOUNT_VALIDATOR = new ReadAmountValidator();

    private ReadAmountValidator() {
    }

    public static int validateAmount(final String amount) {
        return READ_AMOUNT_VALIDATOR.parseAmount(amount);
    }

    private int parseAmount(final String amount) {
        try {
            return Integer.parseInt(isNullAmount(amount));
        } catch (NumberFormatException e) {
            throw new CustomNumberFormatAmountException(AmountExceptionStatus.READ_IS_NOT_NUMERIC);
        }
    }

    private String isNullAmount(final String amount) {
        try {
            return amount.trim();
        } catch (NullPointerException e) {
            throw new CustomNullPointAmountException(AmountExceptionStatus.READ_IS_NULL);
        }
    }
}
