package lotto.util;

import java.util.List;

import static lotto.util.ErrorMessage.*;

public class NumbersValidator {

    public static final int TOTAL_LOTTO_NUMBER = 6;
    public static final int RANDOM_NUMBER_MIN_VALUE = 1;
    public static final int RANDOM_NUMBER_MAX_VALUE = 45;

    private NumbersValidator() {
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != TOTAL_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_OF_LOTTO_ISNT_SIX);
        }
    }

    // TODO: 추가 기능 구현
    public static void checkDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_CANT_BE_DUPLICATED);
        }
    }

    public static void checkElementsInRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < RANDOM_NUMBER_MIN_VALUE || number > RANDOM_NUMBER_MAX_VALUE)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    public static void validateNumber(String input) {
        checkInputEmpty(input);
        checkForWhitespace(input);
        checkNumeric(input);
    }

    public static void validateLottoNumber(String input) {
        checkInputEmpty(input);
        checkForWhitespace(input);
        checkOtherCharacters(input);
    }

    private static void checkInputEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_INPUT);
        }
    }

    private static void checkForWhitespace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_INPUT);
        }
    }

    private static void checkNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_ONLY_NUMBER);
        }
    }

    private static void checkOtherCharacters(String input) {
        String checkString = input.replace(",", "");
        if (checkString.isBlank()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ONLY_COMMA);
        }
    }

}
