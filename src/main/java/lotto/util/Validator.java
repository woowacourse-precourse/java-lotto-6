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

    public static void validateIsParsableToInt(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ErrorMessage.printNotNumericNumberErrorMessage();
            throw new IllegalArgumentException();
        }
    }
}
