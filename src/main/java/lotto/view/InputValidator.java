package lotto.view;

import lotto.exception.EmptyInputException;

public class InputValidator {

    public void validateInput(final String input) {
        if (isInvalidInput(input)) {
            throw new EmptyInputException();
        }
    }

    private boolean isInvalidInput(final String input) {
        return input == null || input.isBlank();
    }
}
