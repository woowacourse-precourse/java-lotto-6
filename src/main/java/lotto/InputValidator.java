package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Constants.*;

public class InputValidator {

    public static void validateIsNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    public static void validateIsNumbers(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    public static void validateIsNumbers(String[] input) {
        for (String s : input) {
            if (!s.matches("^[1-9]\\d*$")) {
                throw new IllegalArgumentException(ERROR_NOT_NUMBER);
            }
        }
    }

    public static void validateIsMultipleOf1000(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_NOT_MULTIPLE_1000);
        }
    }

    public static void validateStringArrayLength(String[] array, int target) {
        if (array.length != target) {
            throw new IllegalArgumentException(ERROR_INCORRECT_LENGTH);
        }
    }

    public static void validateNumberInRange(int number, int minimum, int maximum) {
        if (number > maximum || number < minimum) {
            throw new IllegalArgumentException(ERROR_INCORRECT_RANGE);
        }
    }

    public static void validateIsUnique(List<String> array) {
        Set<String> set = new HashSet<>(array);
        if (set.size() < array.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_NUMBER);
        }
    }
}
