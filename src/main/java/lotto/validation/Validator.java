package lotto.validation;

import lotto.utils.Parser;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {
    private static final int MIN_LOTTO_VALUE = 1;
    private static final int MAX_LOTTO_VALUE = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int CURRENCY = 1000;
    private static final String NULL_ERROR_MESSAGE = "[ERROR] 입력은 null이 될 수 없습니다.";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 입력은 빈 문자열이 될 수 없습니다.";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] 숫자만 입력할 수 있습니다.";
    private static final String NOT_POSITIVE_ERROR_MESSAGE = "[ERROR] 양수만 입력할 수 있습니다.";
    private static final String NOT_DIVISIBLE_ERROR_MESSAGE = "[ERROR] 1,000으로 나누어 떨어지는 숫자만 입력할 수 있습니다.";
    private static final String NOT_ENOUGH_NUMBERS_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복될 수 없습니다.";
    private static final String DUPLICATE_BONUS_ERROR_MESSAGE = "[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.";
    private static final String RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1 ~ 45 사이의 값을 가져야 합니다.";

    private Validator() {
    }

    public static void validate(List<Integer> numbers) {
        isValidSize(numbers);
        isDuplicate(numbers);
    }

    private static void isValidSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(NOT_ENOUGH_NUMBERS_ERROR_MESSAGE);
        }
    }

    private static void isDuplicate(List<Integer> numbers) {
        int duplicateRemovedSize = numbers.stream()
                .distinct()
                .toList()
                .size();

        if (duplicateRemovedSize < numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static void validatePurchasePrice(String input) {
        checkNull(input);
        checkBlank(input);
        checkNumeric(input);
        checkPositive(input);
        checkDivisibility(input);
    }

    public static void validateNumbers(String input) {
        checkNull(input);
        checkBlank(input);
        List<String> strings = Parser.stringToStringList(input);
        checkEachBlank(strings);
        checkEachNumeric(strings);
        checkSize(strings);
        checkDuplicate(strings);
        checkEachRange(strings);
    }

    public static void validateBonusNumber(List<Integer> numbers, String input) {
        checkNull(input);
        checkBlank(input);
        checkNumeric(input);
        checkPositive(input);
        checkRange(Integer.parseInt(input));
        checkAlreadyInLottoNumbers(numbers, input);
    }

    private static void checkNull(String numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private static void checkBlank(String numbers) {
        if (numbers.isEmpty()) {
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

    private static void checkPositive(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }

    private static void checkDivisibility(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber % CURRENCY != 0) {
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

    private static void checkAlreadyInLottoNumbers(List<Integer> lottoNumbers, String input) {
        if (lottoNumbers.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_ERROR_MESSAGE);
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
