package lotto.validator;

import lotto.constant.ErrorMessage;

public class InputValidator {
    public static void validateBudget(String userInput) {
        validateInteger(userInput);
        validatePositiveInteger(userInput);
    }

    private static void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER_MESSAGE.getMessage());
        }
    }

    private static void validatePositiveInteger(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NON_POSITIVE_INTEGER_MESSAGE.getMessage());
        }
    }
}
