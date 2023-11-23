package lotto.exception;

import java.util.function.Supplier;

public class RetryExceptionHandler {
    public <T> T get(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                //todo Printer 사용하기
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }
}
