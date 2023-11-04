package lotto.util;

import java.util.List;

import static lotto.util.LottoInformation.MIN_NUMBER;
import static lotto.util.LottoInformation.MAX_NUMBER;

public class NumberValidator {

    public static void validatePurchaseAmount(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException(NumberErrorMessage.NUMBER_IN_EMPTY.getMessage());
        }

        if (!isNumeric(number)) {
            throw new IllegalArgumentException(NumberErrorMessage.NOT_A_NUMBER.getMessage());
        }

        if (!isWithinIntRange(number)) {
            throw new IllegalArgumentException(NumberErrorMessage.OUT_OF_RANGE.getMessage());
        }

        if (isZero(number)) {
            throw new IllegalArgumentException(NumberErrorMessage.INVALID_ZERO.getMessage());
        }

        if (isNegative(number)) {
            throw new IllegalArgumentException(NumberErrorMessage.NEGATIVE_NUMBER.getMessage());
        }
        if (!isDivisibleByThousands(number)) {
            throw new IllegalArgumentException(NumberErrorMessage.NOT_DIVISIBLE_BY_THOUSANDS.getMessage());
        }
    }

    public static void validateBonusNumber(String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException(NumberErrorMessage.NUMBER_IN_EMPTY.getMessage());
        }

        if (!isNumeric(bonusNumber)) {
            throw new IllegalArgumentException(NumberErrorMessage.NOT_A_NUMBER.getMessage());
        }

        if (!isWithinRange(bonusNumber)) {
            throw new IllegalArgumentException(NumberErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }

    private static boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isWithinIntRange(String number) {
        int maxValue = Integer.MAX_VALUE;

        if (Integer.parseInt(number) <= maxValue) {
            return true;
        }
        return false;
    }

    private static boolean isZero(String number) {
        int numericValue = Integer.parseInt(number);

        if (numericValue == 0) {
            return true;
        }
        return false;
    }

    private static boolean isNegative(String number) {
        int numericValue = Integer.parseInt(number);
        return numericValue < 0;
    }

    private static boolean isDivisibleByThousands(String number) {
        int numericValue = Integer.parseInt(number);
        return numericValue % 1000 == 0;
    }

    private static boolean isWithinRange(String bonusNumberAsString) {
        int bonusNumber = Integer.parseInt(bonusNumberAsString);

        if (bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER) {
            return false;
        }
        return true;
    }
}
