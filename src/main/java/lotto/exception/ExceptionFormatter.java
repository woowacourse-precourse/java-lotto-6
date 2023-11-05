package lotto.exception;

import static lotto.message.ErrorMessage.ERROR_PREFIX;

public class ExceptionFormatter {

    public static String formatErrorMessage(String errorMessage) {
        return String.format(ERROR_PREFIX.getMessage(), errorMessage);
    }

}
