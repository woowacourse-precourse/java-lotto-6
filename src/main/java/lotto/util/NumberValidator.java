package lotto.util;

import java.util.List;

import static lotto.util.LottoInformation.MIN_NUMBER;
import static lotto.util.LottoInformation.MAX_NUMBER;

public class NumberValidator {

    public void validatePurchaseAmount(String number) {
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

    public void validateBonusNumber(String bonusNumber) {
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

    private boolean isNumeric(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isWithinIntRange(String number) {
        int maxValue = Integer.MAX_VALUE;

        if (Integer.parseInt(number) <= maxValue) {
            return true;
        }
        return false;
    }

    private boolean isZero(String number) {
        int numericValue = Integer.parseInt(number);

        if (numericValue == 0) {
            return true;
        }
        return false;
    }

    private boolean isNegative(String number) {
        int numericValue = Integer.parseInt(number);
        return numericValue < 0;
    }

    private boolean isDivisibleByThousands(String number) {
        int numericValue = Integer.parseInt(number);
        return numericValue % 1000 == 0;
    }

    private boolean isWithinRange(String bonusNumberAsText) {
        int bonusNumber = Integer.parseInt(bonusNumberAsText);

        if (bonusNumber > MAX_NUMBER || bonusNumber < MIN_NUMBER) {
            return false;
        }
        return true;
    }

    public static boolean isWinningNumberDuplicate(int bonusNumber, List<Integer> numbers) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(NumberErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
        }
        return true;
    }
}
