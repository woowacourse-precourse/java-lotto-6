package lotto.validator;

import static lotto.exception.ExceptionMessage.AMOUNT_CANNOT_BE_ZERO;
import static lotto.exception.ExceptionMessage.AMOUNT_NOT_DIVISIBLE;
import static lotto.exception.ExceptionMessage.AMOUNT_OUT_OF_BOUNDS;
import static lotto.exception.ExceptionMessage.NUMERIC_VALUES_ONLY;
import static lotto.exception.ExceptionMessage.VALUE_CANNOT_BE_EMPTY_OR_BLANK;

import java.math.BigInteger;

public class InputValidator {
    private static final int LOTTO_PRICE = 1000;

    public void validateLongValueRange(String value) {
        BigInteger valueToCheck = new BigInteger(value);

        if (valueToCheck.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0
                || valueToCheck.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0) {
            throw new IllegalArgumentException(AMOUNT_OUT_OF_BOUNDS.getMessage());
        }
    }

    public void validateNonZeroAmount(String value) {
        if (value.equals("0")) {
            throw new IllegalArgumentException(AMOUNT_CANNOT_BE_ZERO.getMessage());
        }
    }

    public void validateAmountDivisibility(String value) {
        if (Long.parseLong(value) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(AMOUNT_NOT_DIVISIBLE.getMessage());
        }
    }

    public void validateNonEmpty(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(VALUE_CANNOT_BE_EMPTY_OR_BLANK.getMessage());
        }
    }

    public void validateOnlyNumeric(String value) {
        for (int c = 0; c < value.length(); c++) {
            if (!isNumber(value.charAt(c))) {
                throw new IllegalArgumentException(NUMERIC_VALUES_ONLY.getMessage());
            }
        }
    }

    private boolean isNumber(char c) {
        if (48 <= c && c <= 57) {
            return true;
        }

        return false;
    }
}
