package lotto.util;

import java.util.function.Supplier;

public class ExceptionRetryHandler {
    public static <R> R retryUntilValid(Supplier<R> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void retryUntilValid(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
