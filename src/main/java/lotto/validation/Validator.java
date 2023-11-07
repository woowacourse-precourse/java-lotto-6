package lotto.validation;

import lotto.utils.Parser;

import java.util.List;

public class Validator {
    private static final int MIN_LOTTO_VALUE = 1;
    private static final int MAX_LOTTO_VALUE = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String NULL_ERROR_MESSAGE = "[ERROR] 입력은 null이 될 수 없습니다.";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 입력은 빈 문자열이 될 수 없습니다.";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";
    private static final String NEGATIVE_ERROR_MESSAGE = "[ERROR] 음수는 입력할 수 없습니다.";
    private static final String NOT_DIVISIBLE_ERROR_MESSAGE = "[ERROR] 1,000으로 나누어 떨어지는 숫자만 입력할 수 있습니다.";
    private static final String NOT_ENOUGH_NUMBERS_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1 ~ 45 사이의 값을 가져야 합니다.";

    private Validator() {
    }

    public static void validatePurchasePrice(String input) {
        checkNull(input);
        checkBlank(input);
        checkNumeric(input);
        checkNegative(input);
        checkDivisibility(input);
    }

    public static void validateWinningNumbers(String input) {
        checkNull(input);
        checkBlank(input);
        List<String> strings = Parser.stringToStringList(input);
        checkEachBlank(strings);
        checkEachNumeric(strings);
        checkSize(strings);
        checkDuplicate(strings);
        checkEachRange(strings);
    }

    public static void validateBonusNumber(String input) {
        checkNull(input);
        checkBlank(input);
        checkNumeric(input);
        checkNegative(input);
        checkRange(Integer.parseInt(input));
    }

    private static void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private static void checkBlank(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    private static void checkEachBlank(List<String> strings) {
        strings.forEach(Validator::checkBlank);
    }

    private static void checkNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }

    private static void checkEachNumeric(List<String> strings) {
        strings.forEach(Validator::checkNumeric);
    }

    private static void checkNegative(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber < 0) {
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
    }

    private static void checkDivisibility(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_ERROR_MESSAGE);
        }
    }

    private static void checkSize(List<String> input) {
        if (input.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NOT_ENOUGH_NUMBERS_ERROR_MESSAGE);
        }
    }

    private static void checkDuplicate(List<String> strings) {
        long distinctSize = strings.stream()
                .distinct()
                .count();

        if (distinctSize < strings.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    private static void checkRange(int input) {
        if (input < MIN_LOTTO_VALUE ||  MAX_LOTTO_VALUE < input) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private static void checkEachRange(List<String> strings) {
        List<Integer> integers = Parser.stringListToIntList(strings);
        integers.forEach(Validator::checkRange);
    }
}
