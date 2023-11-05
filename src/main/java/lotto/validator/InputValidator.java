package lotto.validator;

import java.util.Objects;

public class InputValidator {

    private static final String NULL_ERROR_MESSAGE = "[ERROR] 입력 값이 null 입니다.";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 값을 입력해 주세요.";

    private InputValidator() {
        throw new IllegalStateException("[ERROR] 해당 클래스는 생성자를 호출할 수 없습니다.");
    }

    public static void validate(final String input) {
        validateNull(input);
        validateEmptyOrWhitespaces(input);
    }

    private static void validateNull(final String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private static void validateEmptyOrWhitespaces(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }


}
