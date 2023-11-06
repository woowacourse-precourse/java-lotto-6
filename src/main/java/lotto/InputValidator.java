package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final String ERROR_BLANK = "[ERROR] 입력된 값이 없습니다.";
    private static final String ERROR_NOT_NUMBER = "[ERROR] 숫자를 입력해야합니다.";
    private static final String ERROR_NOT_MULTIPLE_1000 = "[ERROR] 1000단위로 나누어 떨어지는 숫자가 아닙니다.";
    private static final String ERROR_INCORRECT_LENGTH = "[ERROR] 로또 번호는 6개의 숫자를 입력해야 합니다.";
    private static final String ERROR_INCORRECT_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_DUPLICATED_NUMBER = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";

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
