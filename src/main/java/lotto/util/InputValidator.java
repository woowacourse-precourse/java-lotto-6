package lotto.util;

import lotto.constant.ErrorMessage;

public final class InputValidator {
    private InputValidator() {
    }

    public static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NOT_NUMBER.getMessage());
        }
    }

    public static void validateAllNumbersInteger(String[] input) {
        for (String number : input) {
            validateIsInteger(number);
        }
    }
}
