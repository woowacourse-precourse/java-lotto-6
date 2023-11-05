package lotto.domain.exception;

import java.util.List;
import java.util.function.Supplier;
import lotto.io.LottoMachineConsoleManager;

public class LottoMachineExceptionHandler {
    private static final String ERROR = "[ERROR] ";
    private static final int MAX_ATTEMPTS = 3;
    private static final String MAX_ATTEMPTS_MESSAGE = ERROR + MAX_ATTEMPTS + "회 이상 잘못된 값을 입력하여 프로그램을 종료합니다.";

    public static <T> T handleOperation(Supplier<T> operation) {
        int count = 0;
        while (count <= MAX_ATTEMPTS) {
            try {
                return operation.get();
            } catch (Exception e) {
                count++;
                System.out.println(e.getMessage());
            }
        }

        throw new IllegalStateException(MAX_ATTEMPTS_MESSAGE);
    }

    public static <T> List<T> handleListOperation(Supplier<List<T>> operation) {
        int count = 0;
        while (count <= MAX_ATTEMPTS) {
            try {
                return operation.get();
            } catch (Exception e) {
                count++;
                System.out.println(e.getMessage());
            }
        }

        throw new IllegalStateException(MAX_ATTEMPTS_MESSAGE);
    }
}
