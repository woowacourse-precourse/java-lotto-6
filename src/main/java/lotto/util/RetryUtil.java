package lotto.util;

import java.util.function.Supplier;
import lotto.view.OutputView;

public class RetryUtil {
    public static <T> T read(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e.getMessage());
            return read(supplier);
        }
    }
}
