package lotto.util;

import static lotto.constants.ExceptionMessage.DUPLICATED_NUMBER;
import static lotto.constants.ExceptionMessage.ERROR_FORMAT;
import static lotto.constants.ExceptionMessage.INDIVISIBLE_TO_THOUSAND;
import static lotto.constants.ExceptionMessage.INVALID_COMMA;
import static lotto.constants.ExceptionMessage.INVALID_NUMBER;
import static lotto.constants.ExceptionMessage.NOT_INTEGER;
import static lotto.constants.ExceptionMessage.NOT_POSITIVE;

import java.util.List;

public class Validation {

    public int validateNumeric(String input) {
        int temp;
        try {
            temp = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, NOT_INTEGER+input));
        }
        return temp;
    }
    public void validateCost(int input) {
        validatePositiveNumber(input);
        validateDivisible(input);
    }
    private void validatePositiveNumber(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, NOT_POSITIVE+input));
        }
    }

    private void validateDivisible(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, INDIVISIBLE_TO_THOUSAND+input));
        }
    }

    public void validateNumberRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, INVALID_NUMBER+input));
        }
    }

    public void validateDuplicatedNumber(int input, List<Integer> winningLotto) {
        if (winningLotto.contains(input)) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, DUPLICATED_NUMBER+input));
        }
    }

    public void validateComma(String input) {
        validateNotIncludedComma(input);
        validateFirstOrLastComma(input);
        validateContinuousComma(input);
    }
    private void validateNotIncludedComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, INVALID_COMMA+input));
        }
    }
    private void validateFirstOrLastComma(String input) {
        int lastIndex = input.length()-1;
        if (input.charAt(0) == ',' || input.charAt(lastIndex) == ',') {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, INVALID_COMMA+input));
        }
    }
    private void validateContinuousComma(String input) {
        if (input.contains(",,")) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, INVALID_COMMA+input));
        }
    }
}