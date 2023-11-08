package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static final String ERROR_BLANK = "[ERROR] 입력된 값이 없습니다.";
    public static final String ERROR_NOT_NUMBER = "[ERROR] 숫자를 입력해야합니다.";
    public static final String ERROR_NOT_MULTIPLE = "[ERROR] %d단위로 나누어 떨어지는 숫자가 아닙니다.";
    public static final String ERROR_INCORRECT_LENGTH = "[ERROR] %d개를 입력해야 합니다.";
    public static final String ERROR_INCORRECT_RANGE = "[ERROR] %d부터 %d 사이의 숫자를 입력해야합니다.";
    public static final String ERROR_DUPLICATED_ELEMENT = "[ERROR] 중복된 값을 입력할 수 없습니다.";

    public static void validateIsNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    public static void validateIsNumber(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }

    public static void validateIsNumber(String[] input) {
        for (String s : input) {
            if (!s.matches("^[1-9]\\d*$")) {
                throw new IllegalArgumentException(ERROR_NOT_NUMBER);
            }
        }
    }

    public static void validateIsMultipleOf(String input, int target) {
        if (Integer.parseInt(input) % target != 0) {
            throw new IllegalArgumentException(String.format(ERROR_NOT_MULTIPLE, target));
        }
    }

    public static <T> void validateListLength(List<T> list, int targetLength) {
        if (list.size() != targetLength) {
            throw new IllegalArgumentException(String.format(ERROR_INCORRECT_LENGTH, targetLength));
        }
    }

    public static void validateNumberInRange(int input, int min, int max) {
        if (input > max || input < min) {
            throw new IllegalArgumentException(String.format(ERROR_INCORRECT_RANGE, min, max));
        }
    }

    public static void validateNumberInRange(List<Integer> input, int min, int max) {
        for (Integer number : input) {
            if (number > max || number < min) {
                throw new IllegalArgumentException(String.format(ERROR_INCORRECT_RANGE, min, max));
            }
        }
    }

    public static void validateNumberInRange(String input, int min, int max) {
        int number = Integer.parseInt(input);
        if (number > max || number < min) {
            throw new IllegalArgumentException(String.format(ERROR_INCORRECT_RANGE, min, max));
        }
    }

    public static <T> void validateIsElementUnique(List<T> list) {
        Set<T> set = new HashSet<>(list);
        if (set.size() < list.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_ELEMENT);
        }
    }
}
