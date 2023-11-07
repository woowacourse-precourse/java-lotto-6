package lotto.utils;

import static lotto.enums.ExceptionMessageType.NUMBER_NOT_INTEGER;

public class InputValidator {
    public static void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_NOT_INTEGER.getMessage());
        }
    }
}