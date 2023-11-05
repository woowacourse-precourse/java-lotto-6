package lotto.validator;

import lotto.exception.ParseIntException;
import lotto.exception.UserInputException;
import lotto.util.InputUtil;

public class InputValidator {

    private InputValidator() {
    }

    public static void validateIsNumber(String input) {
        try {
            InputUtil.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ParseIntException(e);
        }
    }
}
