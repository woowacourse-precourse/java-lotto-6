package lotto.validation;

import lotto.exception.ClientException;
import lotto.exception.ExceptionMessage;

public class ViewValidation {

    private final static String NUMERIC_REGEX = "\\d+";
    private final static String COMMA_NUMERIC_REGEX = "^[0-9,]+$";

    public static void validateNumeric(String number) {
        if (!number.matches(NUMERIC_REGEX)) {
            throw new ClientException(ExceptionMessage.MESSAGE_IS_NUMERIC);
        }
    }

    public static void validateCommaNumeric(String numbers) {
        if (!numbers.matches(COMMA_NUMERIC_REGEX)) {
            throw new ClientException(ExceptionMessage.MESSAGE_COMMA_NUMERIC);
        }
    }
}
