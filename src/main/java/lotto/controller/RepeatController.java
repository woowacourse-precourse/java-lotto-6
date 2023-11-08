package lotto.controller;

import java.util.function.Supplier;

public class RepeatController {

    public static <T> T repeat(Supplier<T> supplier) {
        while (true) {
            try {
                T result = supplier.get();
                return result;
            } catch (IllegalArgumentException e) {}
        }
    }
}
