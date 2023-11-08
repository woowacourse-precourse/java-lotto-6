package lotto.exception.exceptionhandler;

import java.util.function.Supplier;

public interface ExceptionHandler {
    <T> T getResult(Supplier<T> supplier);
}
