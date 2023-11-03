package lotto.exception;

import java.util.function.Supplier;

public class ExceptionResolver {

    private ExceptionResolver() {
    }

//    public static void resolveProcess(Runnable runnable) {
//        try {
//            runnable.run();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            resolve(runnable);
//        }
//    }

    public static <T> T resolveInput(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            printExceptionMessage(e.getMessage());
            return resolveInput(supplier);
        }
    }

    private static void printExceptionMessage(final String message) {
        System.out.println(message);
    }
}
