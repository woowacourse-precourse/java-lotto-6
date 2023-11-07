package lotto;

import lotto.message.ExceptionMessage;

public class TypeValidator {
    public static void validateNumber(String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_FORMAT);
        }
    }
}
