package lotto.exception;

import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T, R> R handle(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return handle(function, t);
        }
    }

    public static <T> T handle(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return handle(supplier);
        }
    }

    private static void printExceptionMessage(IllegalArgumentException e) {
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
    }
}
