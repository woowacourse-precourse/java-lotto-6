package lotto.view.inputview;

import static lotto.Error.View.NOT_NUMBER;
import static lotto.Error.View.WRONG_INPUT;

public final class InputValidator {
    private InputValidator() {
    }

    public static boolean validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getText());
        }
    }

    public static void validateIsEmptyValue(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(WRONG_INPUT.getText());
        }
    }
}
