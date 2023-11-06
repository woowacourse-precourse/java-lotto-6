package lotto.utils;

public class InputValidator {
    public static void validateEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 금액은 입력 불가");
        }
    }

    public static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null 입력 불가");
        }
    }
}
