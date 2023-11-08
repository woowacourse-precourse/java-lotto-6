package lotto.util;

import java.util.function.Supplier;

public class ExceptionRetryHandler {
    public static <R> R retryUntilValid(Supplier<R> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void retryUntilValid(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
