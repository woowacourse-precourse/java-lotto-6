package lotto.util;

public class Validation {
    private static final String INPUT_NOT_NUMBER = "[ERROR] 숫자가 아닌 다른 값이 입력되었습니다.";

    public static void validateIsNotNumber(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER);
        }
    }
}
