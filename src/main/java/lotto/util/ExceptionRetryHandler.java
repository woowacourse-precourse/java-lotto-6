package lotto.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionRetryHandler {
    public static <R> R retryUntilValid(Supplier<R> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
            }
        }
    }

    public static <T> void retryUntilValid(Consumer<T> consumer, T argument) {
        while (true) {
            try {
                consumer.accept(argument);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + System.lineSeparator());
            }
        }
    }
}
