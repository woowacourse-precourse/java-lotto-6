package lotto.validator;

import java.util.List;

public class StringValidator {
    public static void validateOnlyNumber(List<String> line) {
        line.forEach(StringValidator::validateOnlyNumber);
    }

    public static void validateOnlyNumber(String line) {
        validateNotBlank(line);
        for (char c : line.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
    }

    public static void validateNotBlank(String line) {
        validateNotNull(line);
        if (line.isBlank()) {
            throw new IllegalArgumentException("로또 구입 금액을 입력하세요.");
        }
    }

    public static void validateNotNull(String line) {
        if (line == null) {
            throw new IllegalArgumentException("로또 구입 금액을 입력하세요.");
        }
    }


}
