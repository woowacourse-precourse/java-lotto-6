package lotto.model.winning;

import java.util.function.Predicate;

public enum BonusNumberValidator {
    EMPTY_VALIDATOR(BonusNumberValidator::isNotEmpty, "[ERROR] 번호가 입력되지 않았습니다."),
    NUMBER_FORMAT_VALIDATOR(BonusNumberValidator::isNumberFormat, "[ERROR] 보너스 번호는 숫자여야 합니다."),
    SIZE_VALIDATOR(BonusNumberValidator::isValidSize, "[ERROR] 보너스 번호는 1개의 숫자여야 합니다."),
    NUMBER_RANGE_VALIDATOR(BonusNumberValidator::isWithinRange, "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;
    private static final int MAX_BONUS_NUMBER_LENGTH = 2;
    private static final String NUMBER_REGEX = "^[0-9]*$";

    private final Predicate<String> validation;
    private final String errorMessage;

    BonusNumberValidator(Predicate<String> validation, String errorMessage) {
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
        return input.matches(NUMBER_REGEX);
    }

    private static boolean isValidSize(String input) {
        return input.length() <= MAX_BONUS_NUMBER_LENGTH;
    }

    private static boolean isWithinRange(String input) {
        int number = Integer.parseInt(input);
        return number >= MIN_BONUS_NUMBER && number <= MAX_BONUS_NUMBER;
    }
}
