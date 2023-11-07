package lotto.utils;

import java.util.function.Supplier;
import lotto.view.OutputView;

public class RepeatReader {
    private RepeatReader() {

    }

    public static <T> T read(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return read(supplier);
        }
    }
}
