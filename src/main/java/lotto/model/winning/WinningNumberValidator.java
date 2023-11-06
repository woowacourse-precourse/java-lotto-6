package lotto.model.winning;

import java.util.Arrays;
import java.util.function.Predicate;

public enum WinningNumberValidator {
    EMPTY_VALIDATOR(input -> !input.isEmpty(), "[ERROR] 번호가 입력되지 않았습니다."),
    NUMBER_FORMAT_VALIDATOR(input -> input.matches("^[0-9,]*$"), "[ERROR] 숫자 또는 쉼표(,)로만 구성되어야 합니다."),
    SIZE_VALIDATOR(input -> input.split(",").length == 6, "[ERROR] 로또 당첨 번호는 6개의 숫자여야 합니다."),
    NUMBER_RANGE_VALIDATOR(input -> Arrays.stream(input.split(",")).map(Integer::parseInt).allMatch(number -> number >= 1 && number <= 45), "[ERROR] 로또 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATION_VALIDATOR(input -> Arrays.stream(input.split(",")).distinct().count() == 6, "[ERROR] 로또 당첨 번호는 중복될 수 없습니다.");

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
}