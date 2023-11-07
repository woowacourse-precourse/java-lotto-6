package lotto.validation;

import static lotto.message.ErrorMessage.ERROR_MESSAGE_HEAD;
import static lotto.message.ErrorMessage.INVALID_MONEY_FORMAT_EXCEPTION;

public class InputFormatValidator {
    public static void validateMoneyFormat(String input) {
        if (input.matches("[1-9][0-9]*")) {
            return;
        }

        throw new IllegalArgumentException(ERROR_MESSAGE_HEAD + INVALID_MONEY_FORMAT_EXCEPTION);
    }
}
