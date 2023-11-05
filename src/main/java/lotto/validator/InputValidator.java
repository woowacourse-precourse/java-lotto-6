package lotto.validator;

import lotto.exception.ParseIntException;
import lotto.util.InputUtil;

public class InputValidator {

    public static void validateIsNumber(String input) {
        try {
            InputUtil.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ParseIntException(e);
        }
    }
}
