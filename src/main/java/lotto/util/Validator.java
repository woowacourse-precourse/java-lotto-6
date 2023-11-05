package lotto.util;

import java.util.regex.Pattern;

public class Validator {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

    private static final String BLANK_INPUT_ERROR_MESSAGE = "공백이 아닌 문자를 입력해주세요.";
    private static final String INVALID_LENGTH_INPUT_ERROR_MESSAGE = "유효하지 않은 입력 길이입니다.";
    private static final String INVALID_NUMERIC_INPUT_MESSAGE = "숫자로만 입력해주세요.";

    private Validator() {
    }

    public static void validateHasText(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateLength(String input, int maxLength) {
        if (input == null || input.length() > maxLength) {
            throw new IllegalArgumentException(INVALID_LENGTH_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateNumeric(String input) {
        if (!NUMERIC_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_NUMERIC_INPUT_MESSAGE);
        }
    }
}
