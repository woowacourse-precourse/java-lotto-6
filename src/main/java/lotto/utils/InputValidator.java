package lotto.utils;

import lotto.utils.enums.ErrorMessage;

public class InputValidator {
    public static void validateNumberInRange(
            int number, String code) throws IllegalArgumentException {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(code + ErrorMessage.NUMBER_NOT_INRANGE.getMessage());
        }
    }
}
