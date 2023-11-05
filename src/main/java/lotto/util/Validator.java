package lotto.util;

import static lotto.util.ErrorMessage.EMPTY_INPUT;
import static lotto.util.ErrorMessage.INVALID_INTEGER;

public class Validator {

    public void validate(String userInput) throws IllegalArgumentException {
        validateEmpty(userInput);
        validateDigit(userInput);
        validateRange(userInput);
    }
    private void validateEmpty(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT.getMessage());
        }
    }

    private void validateDigit(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INTEGER.getMessage());
        }
    }

    private void validateRange(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number <= 0) {
            throw new IllegalArgumentException(INVALID_INTEGER.getMessage());
        }
    }
}
