package lotto.exception;

import lotto.util.OutputUtils;

public class ExceptionHandler {

    public static void triggerArgException(ErrorMessage message) throws IllegalArgumentException {
        OutputUtils.printErrorMessage(message.getMessage());
        throw new IllegalArgumentException(message.getMessage());
    }
}
