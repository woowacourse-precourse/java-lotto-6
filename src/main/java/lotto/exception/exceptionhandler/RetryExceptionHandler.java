package lotto.exception.exceptionhandler;

import java.util.function.Supplier;
import lotto.view.TerminalUI;

public class RetryExceptionHandler implements ExceptionHandler {

    TerminalUI ui = new TerminalUI();

    /**
     * 전달된 supplier를 하나의 트랜잭션으로 판단합니다. supplier를 수행 중 IllegalArgumentException이 발생하면 예외 메시지를 출력 후 트랜잭션을 처음부터 다시 실행합니다.
     *
     * @param supplier - 값을 생성하는 하나의 트랜잭션 단위 로직
     * @return supplier로 생성된 T 타입 객체
     */
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
