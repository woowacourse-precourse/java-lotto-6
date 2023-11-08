package lotto.validator;

import lotto.constants.ErrorMessage;

public class Validator {
    public static int validateInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }
}
