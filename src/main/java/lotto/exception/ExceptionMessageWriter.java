package lotto.exception;

import static lotto.exception.ExceptionConstant.ERROR_PREFIX;

public final class ExceptionMessageWriter {
    public static void showExceptionMessage(String message) {
        System.out.printf("%s %s%n", ERROR_PREFIX, message);
    }
}
