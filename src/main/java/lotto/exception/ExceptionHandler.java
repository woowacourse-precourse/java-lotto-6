package lotto.exception;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T, R> R handle(final Function<T, R> function, final T t) {
        try {
            return function.apply(t);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return handle(function, t);
        }
    }

    public static <T, U, R> R handle(final BiFunction<T, U, R> function, final T t, final U u) {
        try {
            return function.apply(t, u);
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return handle(function, t, u);
        }
    }

    public static <T> T handle(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return handle(supplier);
        }
    }

    private static void printExceptionMessage(final IllegalArgumentException e) {
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
    }
}
