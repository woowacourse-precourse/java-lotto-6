package lotto.domain;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Repeater {
    private final Consumer<String> errorPrinter;

    public Repeater(Consumer<String> errorPrinter) {
        this.errorPrinter = errorPrinter;
    }

    public <R> R repeatBeforeSuccess(Supplier<R> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                errorPrinter.accept(e.getMessage());
            }
        }
    }
}
