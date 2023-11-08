package lotto.utils;

import java.util.function.Supplier;
import lotto.constants.ErrorConstants;
import lotto.view.OutputView;

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
        OutputView.printExceptionMessage(ErrorConstants.getErorrMessage(e.getMessage()));
    }
}
