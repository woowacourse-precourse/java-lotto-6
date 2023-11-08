package lotto.Validation;

import lotto.view.enums.ErrorMessage;

public class InputValidator {
    public void checkIsNotBlank(String input) throws IllegalArgumentException {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK.getMessage());
        }
    }

    public void checkCanParseInt(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.CANT_PARSEINT.getMessage());
        }
    }
}
