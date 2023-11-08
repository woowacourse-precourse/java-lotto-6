package lotto.global.utils;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionHandlingUtil {

    private ExceptionHandlingUtil() {
        
    }

    public static <T> T handleException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static <T> T handleExceptionWithMessage(Consumer<String> consumer, Supplier<T> supplier) {
        while (true) {
            try {
                consumer.accept("");
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
