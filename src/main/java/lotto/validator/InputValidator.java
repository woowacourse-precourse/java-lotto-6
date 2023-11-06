package lotto.view;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String NUMBERS_REGEX = "^(\\d+(,\\d+)*)+$";
    private static final Pattern NUMBERS_PATTERN = Pattern.compile(NUMBERS_REGEX);
    private static final String NUMBER_REGEX = "\\d+";
    private static final Pattern NUMBER_PATTERN = Pattern.compile(NUMBER_REGEX);

    public static void verifyValidaNumberFormat(String input) {
        if (!NUMBERS_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("쉼표 구분하여 숫자만 입력해주세요.");
        }
    }

    public static void verifyNonEmptyInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
    }

    public static void verifyNumericString(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }
}
