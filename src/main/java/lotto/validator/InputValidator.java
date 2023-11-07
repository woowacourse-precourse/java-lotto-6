package lotto.validator;

public class InputValidator {
    public static void validateNumber(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요");
        }
    }

    public static void validateInputRequirement(String input) {
        if (!input.matches("^[0-9]+(,[0-9]+)*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자와 쉼표(,)만 입력하세요");
        }
    }
}
