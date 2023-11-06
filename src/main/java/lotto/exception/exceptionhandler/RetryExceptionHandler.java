package lotto.exception.exceptionhandler;

import java.util.function.Supplier;
import lotto.view.TerminalUI;

public class RetryExceptionHandler implements ExceptionHandler {

    TerminalUI ui = new TerminalUI();

    @Override
    public <T> T getResult(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                printException(e);
            } finally {
                afterHandlingException();
            }
        }
    }

    private void printException(IllegalArgumentException e) {
        ui.printException(e);
    }

    private void afterHandlingException() {
        ui.printEmptyLine();
    }
}
