package lotto.model.winning;

import java.util.Arrays;
import java.util.function.Predicate;

public enum WinningNumberValidator {
    EMPTY_VALIDATOR(WinningNumberValidator::isNotEmpty, "[ERROR] 번호가 입력되지 않았습니다."),
    NUMBER_FORMAT_VALIDATOR(WinningNumberValidator::isNumberFormat, "[ERROR] 숫자 또는 쉼표(,)로만 구성되어야 합니다."),
    SIZE_VALIDATOR(WinningNumberValidator::isValidSize, "[ERROR] 로또 당첨 번호는 6개의 숫자여야 합니다."),
    NUMBER_RANGE_VALIDATOR(WinningNumberValidator::isWithinRange, "[ERROR] 로또 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATION_VALIDATOR(WinningNumberValidator::isDistinct, "[ERROR] 로또 당첨 번호는 중복될 수 없습니다.");

    private static final int MIN_WINNING_NUMBER = 1;
    private static final int MAX_WINNING_NUMBER = 45;
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final String NUMBER_FORMAT_REGEX = "^[0-9,]*$";
    private static final String DELIMITER_REGEX = ",";

    private final Predicate<String> validation;
    private final String errorMessage;

    WinningNumberValidator(Predicate<String> validation, String errorMessage) {
        this.validation = validation;
        this.errorMessage = errorMessage;
    }

    public void validate(String input) {
        if (!validation.test(input)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private static boolean isNotEmpty(String input) {
        return !input.isEmpty();
    }

    private static boolean isNumberFormat(String input) {
        return input.matches(NUMBER_FORMAT_REGEX);
    }

    private static boolean isValidSize(String input) {
        return input.split(DELIMITER_REGEX).length == WINNING_NUMBERS_SIZE;
    }

    private static boolean isWithinRange(String input) {
        return Arrays.stream(input.split(DELIMITER_REGEX))
                .map(Integer::parseInt)
                .allMatch(number -> number >= MIN_WINNING_NUMBER && number <= MAX_WINNING_NUMBER);
    }

    private static boolean isDistinct(String input) {
        return Arrays.stream(input.split(DELIMITER_REGEX))
                .distinct()
                .count() == WINNING_NUMBERS_SIZE;
    }
}
