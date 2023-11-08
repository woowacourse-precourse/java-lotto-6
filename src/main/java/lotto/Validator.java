package lotto;

import lotto.domain.Lotto;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constants.Error.*;
import static lotto.constants.Numbers.*;
import static lotto.constants.Strings.*;

public class Validator {
    public static void validateNumberString(String input) {
        if (!Pattern.matches(REG_NUMBER_STRING, input)) {
            throw new IllegalArgumentException(NON_NUMBER.getMessage());
        }
    }

    public static void validateNumberCommaString(String inputLotto) {
        if (!Pattern.matches(REG_NUMBER_COMMA_STRING, inputLotto)) {
            throw new IllegalArgumentException(NON_NUMBER_COMMA.getMessage());
        }
        if (inputLotto.contains(COMMA + COMMA)) {
            throw new IllegalArgumentException(CONTINUAL_COMMA.getMessage());
        }
        if (Pattern.matches(REG_COMMA_EDGE_STRING, inputLotto)) {
            throw new IllegalArgumentException(COMMA_EDGE.getMessage());
        }
    }

    public static void validatePlusSign(long number) {
        if (number <= ZERO) {
            throw new IllegalArgumentException(NOT_PLUS_SIGN.getMessage());
        }
    }

    public static void validateDivision(long number) {
        if (number % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException(NOT_PLUS_SIGN.getMessage());
        }
    }

    public static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(WRONG_SIZE.getMessage());
        }
    }

    public static void validateRange(List<Integer> numbers, int minNumber, int maxNumber) {
        if (!numbers.stream()
                .allMatch(number -> number >= minNumber && number <= maxNumber)) {
            throw new IllegalArgumentException(NOT_IN_RANGE.getMessage());
        }
    }

    public static void validateRange(int number, int minNumber, int maxNumber) {
        if (!(number >= minNumber) && (number <= maxNumber)) {
            throw new IllegalArgumentException(NOT_IN_RANGE.getMessage());
        }
    }

    public static void validateDuplicates(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATES.getMessage());
        }
    }

    public static void validateDuplicates(Lotto lotto, int number) {
        if (lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(DUPLICATES.getMessage());
        }
    }
}
