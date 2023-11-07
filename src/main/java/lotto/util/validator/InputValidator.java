package lotto.util.validator;

import lotto.config.ErrorMessage;

public class InputValidator {
    final String input;

    public InputValidator(String input) {
        validateEmpty(input);
        this.input = input;
    }

    private void validateEmpty(String input) {
        if (input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY.getMessage());
        }
    }
}
