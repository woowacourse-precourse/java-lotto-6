package lotto.util.validator;

import java.util.regex.Pattern;

public class NumberValidator{
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

    public static void validate(Object value) {
        validateNull((String) value);
        validateNumber((String) value);
        validateRange((String) value);
    }

    private static void validateNull(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
    }

    private static void validateNumber(String value) {
        if (!NUMBER_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("숫자로 입력해야합니다.");
        }
    }

    private static void validateRange(String rawValue) {
        try {
            Integer.parseInt(rawValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정상적인 범위 내의 숫자를 입력해야합니다.");
        }
    }

    private NumberValidator() {
    }
}
