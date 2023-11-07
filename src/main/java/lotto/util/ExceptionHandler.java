package lotto.util;

import java.util.function.Supplier;

public class ExceptionHandler {
    public static <T> T handle(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return handle(supplier);
        }
    }
}
