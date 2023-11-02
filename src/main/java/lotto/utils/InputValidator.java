package lotto.utils;

public class InputValidator {

    public static void nullCheck(String inputValue) {
        if (inputValue == null) {
            throw new IllegalArgumentException();
        }
    }

    public static void blankCheck(String inputValue) {
        if (inputValue.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public static int numberTypeCheck(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getCause());
        }
    }
}
