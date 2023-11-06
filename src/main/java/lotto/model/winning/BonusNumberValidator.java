package lotto.model.winning;

import java.util.function.Predicate;

public enum BonusNumberValidator {
    EMPTY_VALIDATOR(input -> !input.isEmpty(), "[ERROR] 번호가 입력되지 않았습니다."),
    NUMBER_FORMAT_VALIDATOR(input -> input.matches("^[0-9]*$"), "[ERROR] 보너스 번호는 숫자여야 합니다."),
    SIZE_VALIDATOR(input -> input.length() <= 2, "[ERROR] 보너스 번호는 1개의 숫자여야 합니다."),
    NUMBER_RANGE_VALIDATOR(input -> Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 45, "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");

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
}
