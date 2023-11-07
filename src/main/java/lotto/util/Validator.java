package lotto.util;

public class Validator {
    private Validator() {
    }

    public static void validateInputNotEmpty(String input) {
        if (input.trim().isEmpty()) {
            ErrorMessage.printBlankInputErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
