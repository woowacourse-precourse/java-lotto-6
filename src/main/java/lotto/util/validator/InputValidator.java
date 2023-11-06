package lotto.util.validator;

import lotto.config.ErrorMessage;

public class InputValidator {
    final String input;

    public InputValidator(String input) {
        validateEmpty();
        this.input = input;
    }

    private void validateEmpty() {
        if(input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY.getMessage());
        }
    }
}
