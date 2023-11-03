package lotto.util;

import java.util.function.Function;
import java.util.function.Supplier;
import lotto.view.OutputView;

/**
 * 재시도를 위한 유틸리티 클래스 주로 사용자로부터 입력 값을 받아들이기에 대부분인 Return 값이 존재한다.
 */
public final class RetryUtil {

    private static final OutputView OUTPUT_VIEW = OutputView.getInstance();

    private RetryUtil() {
    }

    /**
     * 매개변수 X, 반환값 O
     * <p>
     * [예시] 1. view부터 dto을 받을때 2. dto을 domain으로 변환할때
     */
    public static <T> T retryOnFail(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OUTPUT_VIEW.printExceptionMessage(e.getMessage());
            return retryOnFail(supplier);
        }
    }

    /**
     * 매개변수 T, 반환값 R
     */
    public static <T, R> R retryOnFail(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            OUTPUT_VIEW.printExceptionMessage(e.getMessage());
            return retryOnFail(function, input);
        }
    }
}
