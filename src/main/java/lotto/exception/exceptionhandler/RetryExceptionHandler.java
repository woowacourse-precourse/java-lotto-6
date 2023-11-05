package lotto.exception.exceptionhandler;

import java.util.function.Supplier;
import lotto.view.io.Writer;

public class RetryExceptionHandler implements ExceptionHandler {

    @Override
    public void run(Runnable runnable) {
        while (true) {
            try {
                runnable.run();
                return;
            } catch (IllegalArgumentException e) {
                printException(e);
            } finally {
                System.out.println();
            }
        }
    }

    @Override
    public <T> T getResult(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                printException(e);
            } finally {
                System.out.println();
            }
        }
    }

    private void printException(IllegalArgumentException e){
        Writer.printException(e);
    }
}
