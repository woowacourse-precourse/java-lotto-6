package lotto.view.validator;

import static lotto.exception.ErrorMessage.VALIDATE_INPUT_EMPTY;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_NUMBER;

public class InputNumberValidator {
    private InputNumberValidator() {}

    public static void checkEmpty(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException(VALIDATE_INPUT_EMPTY.getMessage());
        }
    }

    public static void checkNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_INPUT_NUMBER.getMessage());
        }
    }


}
