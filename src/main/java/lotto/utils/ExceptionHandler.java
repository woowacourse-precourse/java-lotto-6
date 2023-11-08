package lotto.utils;

import java.util.function.Supplier;
import lotto.constants.ErrorConstants;

public class ExceptionHandler {
    public static <T> T input(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            printExceptionMessage(e);
            return input(supplier);
        }
    }

    private static void printExceptionMessage(final IllegalArgumentException e) {
        System.out.println(ErrorConstants.getErorrMessage(e.getMessage()));
    }
}
