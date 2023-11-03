package lotto.util;

import static lotto.constants.ExceptionMessage.DUPLICATED_NUMBER;
import static lotto.constants.ExceptionMessage.ERROR_FORMAT;
import static lotto.constants.ExceptionMessage.INDIVISIBLE_TO_THOUSAND;
import static lotto.constants.ExceptionMessage.INVALID_COMMA;
import static lotto.constants.ExceptionMessage.INVALID_NUMBER;
import static lotto.constants.ExceptionMessage.NOT_INTEGER;
import static lotto.constants.ExceptionMessage.NOT_POSITIVE;
import static lotto.constants.ExceptionMessage.NOT_SIX_NUMBERS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public static int validateInteger(String input) {
        int temp;
        try {
            temp = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, NOT_INTEGER+input));
        }
        return temp;
    }
    public static void validateCost(int input) {
        validatePositiveNumber(input);
        validateDivisible(input);
    }
    private static void validatePositiveNumber(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, NOT_POSITIVE+input));
        }
    }

    private static void validateDivisible(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, INDIVISIBLE_TO_THOUSAND+input));
        }
    }

    public static void validateBonusNum(int input) {
        validateNumberRange(input);
    }
    public static void validateNumberRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, INVALID_NUMBER+input));
        }
    }
    public static void validateDuplicatedBonusNum(int input, List<Integer> numbers) {
        if (numbers.contains(input)) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, DUPLICATED_NUMBER));
        }
    }
    public static void validateSixLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, NOT_SIX_NUMBERS));
        }
    }
    public static void validateDuplicatedSixNumber(List<Integer> numbers) {
        Set<Integer> temp = new HashSet<>(numbers);
        if (temp.size() != numbers.size()) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, DUPLICATED_NUMBER));
        }
    }

    public static void validateComma(String input) {
        validateNotIncludedComma(input);
        validateFirstOrLastComma(input);
        validateContinuousComma(input);
    }
    private static void validateNotIncludedComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, INVALID_COMMA+input));
        }
    }
    private static void validateFirstOrLastComma(String input) {
        int lastIndex = input.length()-1;
        if (input.charAt(0) == ',' || input.charAt(lastIndex) == ',') {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, INVALID_COMMA+input));
        }
    }
    private static void validateContinuousComma(String input) {
        if (input.contains(",,")) {
            throw new IllegalArgumentException(String.format(ERROR_FORMAT, INVALID_COMMA+input));
        }
    }
}