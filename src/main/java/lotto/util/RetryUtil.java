package lotto.util;

import java.util.function.Function;
import java.util.function.Supplier;
import lotto.view.OutputView;

public final class RetryUtil {
    private static final OutputView OUTPUT_VIEW = OutputView.getInstance();

    private RetryUtil() {
    }

    public static <T> T retryOnFail(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OUTPUT_VIEW.printExceptionMessage(e.getMessage());
            return retryOnFail(supplier);
        }
    }

    public static <T, R> R retryOnFail(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            OUTPUT_VIEW.printExceptionMessage(e.getMessage());
            return retryOnFail(function, input);
        }
    }
}
