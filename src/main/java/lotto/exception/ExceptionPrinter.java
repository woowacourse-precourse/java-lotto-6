package lotto.exception;

import static lotto.Constants.ERROR_PREFIX;

public class ExceptionPrinter {
    public static void printExceptionMessage(Exception e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}
