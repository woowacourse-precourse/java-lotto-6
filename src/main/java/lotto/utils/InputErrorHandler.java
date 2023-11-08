package lotto.utils;

import java.lang.reflect.Executable;

public class InputErrorHandler {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printErrorMessageAndRetry(Runnable runnable) {
        boolean isFailed = true;
        while (isFailed) {
            try {
                runnable.run();
                isFailed = false;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }
}
