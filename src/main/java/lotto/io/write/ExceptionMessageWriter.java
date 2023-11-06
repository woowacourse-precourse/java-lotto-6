package lotto.io.write;

import static lotto.io.constant.ExceptionConstant.ERROR_PREFIX;

public final class ExceptionMessageWriter {
    public static void showExceptionMessage(String message) {
        System.out.printf("%s %s%n", ERROR_PREFIX, message);
    }
}
