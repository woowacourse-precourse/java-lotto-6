package lotto.exception.exceptionhandler;

import java.util.function.Supplier;

public interface ExceptionHandler {
    void run(Runnable runnable);

    <T> T getResult(Supplier<T> supplier);
}
