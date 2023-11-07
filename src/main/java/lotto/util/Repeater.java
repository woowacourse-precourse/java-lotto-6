package lotto.util;

import java.util.function.Supplier;

public class Repeater {
    public static <T> T untilNotException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static <T> T tryOnceMoreIfException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return supplier.get();
        }
    }
}
