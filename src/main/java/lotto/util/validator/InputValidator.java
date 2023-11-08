package lotto.util.validator;

import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

    private InputValidator() {
    }

    public static void validateNumber(Object value) {
        validateNumber((String) value);
        validateRange((String) value);
    }

    public static void validateNull(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private static void validateNumber(String value) {
        if (!isNumber(value)) {
            throw new IllegalArgumentException("숫자로 입력해야합니다.");
        }
    }

    private static boolean isNumber(String value) {
        return NUMBER_PATTERN.matcher(value).matches();
    }

    private static void validateRange(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정상적인 범위 내의 숫자를 입력해야합니다.");
        }
    }
}
