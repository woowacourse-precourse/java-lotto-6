package lotto.validator;

import lotto.constant.ErrorMessage;

public class InputValidator {

    public static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.NON_INTEGER_ERROR.getMessage());
        }
    }
}
