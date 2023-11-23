package lotto.exception;

import java.util.function.Supplier;
import lotto.view.io.Printer;

public class RetryExceptionHandler {
    private final Printer printer = new Printer();

    public <T> T get(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                printer.printMessage(e.getMessage());
            } finally {
                printer.printMessage("");
            }
        }
    }
}
