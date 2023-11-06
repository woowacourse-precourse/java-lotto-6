package lotto.util.validator;

import java.util.List;

public class StringValidator {
    public static void validateOnlyNumber(List<String> line) {
        line.forEach(StringValidator::validateOnlyNumber);
    }

    public static void validateOnlyNumber(String line) {
        final String message = "숫자만 입력 가능합니다.";
        validateNotBlank(line);
        for (char c : line.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(message);
            }
        }
    }

    public static void validateNotBlank(String line) {
        final String message = "로또 구입 금액을 입력하세요.";
        validateNotNull(line);
        if (line.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNotNull(String line) {
        final String message = "로또 구입 금액을 입력하세요.";
        if (line == null) {
            throw new IllegalArgumentException(message);
        }
    }


}
