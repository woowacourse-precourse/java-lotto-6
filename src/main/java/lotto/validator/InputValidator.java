package lotto.validator;

import static lotto.exception.ExceptionMessage.AMOUNT_CANNOT_BE_ZERO;
import static lotto.exception.ExceptionMessage.AMOUNT_NOT_DIVISIBLE;
import static lotto.exception.ExceptionMessage.AMOUNT_OUT_OF_BOUNDS;
import static lotto.exception.ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.exception.ExceptionMessage.NON_ZERO_STARTING_POSITIVE_NUMBERS_REQUIRED;
import static lotto.exception.ExceptionMessage.NO_DUPLICATES_ALLOWED;
import static lotto.exception.ExceptionMessage.NUMBER_OUT_OF_RANGE;
import static lotto.exception.ExceptionMessage.NUMERIC_VALUES_ONLY;
import static lotto.exception.ExceptionMessage.VALUE_CANNOT_BE_EMPTY_OR_BLANK;

import java.math.BigInteger;
import java.util.HashSet;

public class InputValidator {
    private static final int LOTTO_PRICE = 1000;
    private static final int NUMBERS_COUNT_PER_LOTTO = 6;
    private static final BigInteger MIN_OF_LOTTO_NUMBER = BigInteger.ONE;
    private static final BigInteger MAX_OF_LOTTO_NUMBER = BigInteger.valueOf(45);

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

    public String[] validateSeparatedByComma(String value) {
        String[] winningNumbers = value.split(",", -1);

        if (winningNumbers.length != NUMBERS_COUNT_PER_LOTTO) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBER_FORMAT.getMessage());
        }

        return winningNumbers;
    }

    public void validateOnlyNumericValues(String[] winningNumbers) {
        for (int i = 0; i < winningNumbers.length; i++) {
            if (!isValidNumeric(winningNumbers[i])) {
                throw new IllegalArgumentException(NON_ZERO_STARTING_POSITIVE_NUMBERS_REQUIRED.getMessage());
            }
        }
    }

    private boolean isValidNumeric(String value) {
        return value.matches("[1-9]\\d*");
    }

    public void validateNumbersInRange(String value) {
        BigInteger number = new BigInteger(value);

        if (number.compareTo(MIN_OF_LOTTO_NUMBER) < 0 || number.compareTo(MAX_OF_LOTTO_NUMBER) > 0) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public void validateNoDuplicates(String[] winningNumbers) {
        HashSet<String> tempForCheck = new HashSet<>();

        for (int i = 0; i < winningNumbers.length; i++) {
            tempForCheck.add(winningNumbers[i]);
        }

        if (tempForCheck.size() != winningNumbers.length) {
            throw new IllegalArgumentException(NO_DUPLICATES_ALLOWED.getMessage());
        }
    }

    public void validateNumericOnly(String value) {
        if (!isValidNumeric(value)) {
            throw new IllegalArgumentException(NON_ZERO_STARTING_POSITIVE_NUMBERS_REQUIRED.getMessage());
        }
    }
}
