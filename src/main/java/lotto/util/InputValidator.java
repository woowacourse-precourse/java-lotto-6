package lotto.util;

public class InputValidator {
    public static void validateNumeric() {

    }

    public static void validatePositiveNumber() {

    }

    public static void validateEmptyInput(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 비어있습니다.");
        }
    }
}
