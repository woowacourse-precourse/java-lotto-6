package lotto.exception;

import java.util.function.Supplier;

public class ExceptionResolver {

    private ExceptionResolver() {
    }

    public static <T> T resolveInput(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            printExceptionMessage(e.getMessage());
            return resolveInput(supplier);
        }
    }

    public static void resolveProcess(final Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            printExceptionMessage(e.getMessage());
            resolveProcess(runnable);
        }
    }

    private static void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
