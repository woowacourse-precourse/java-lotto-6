package lotto.study;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Supplier;
import lotto.common.log.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Exception과 try-catch를 학습하기 위한 테스트이다.")
public class ExceptionTest {

    @DisplayName("try구문에서 Exception이 발생하면 Catch구문으로 넘어간다.")
    @Test
    void moveToCatchBlock_whenExceptionIsThrownByTryBlock() {
        // given
        boolean hasError = false;

        // when
        try {
            throw new IllegalArgumentException("예외 발생");
        } catch (IllegalArgumentException e) {
            hasError = true;
        }

        // then
        assertThat(hasError).isTrue();
    }

    @DisplayName("Exception이 발생하면 그 다음 코드를 실행하지 않는다.")
    @Test
    void exceptionDoesntExecuteNextLineOnceItOccurs() {
        // given
        boolean hasError = false;
        int executedCount = 0;

        // when
        try {
            throwIllegalArgumentExceptionWhenHasErrorIsFalse(hasError);
            executedCount++;
        } catch (IllegalArgumentException e) {
            hasError = true;
        }

        // then
        assertThat(executedCount).isEqualTo(0);
    }

    @DisplayName("Exception이 발생하면 다시 try 구문으로 돌아가지 않는다.")
    @Test
    void exceptionDoesntReturnToTryBlockOnceItOccurs() {
        // given
        boolean hasError = false;
        int executedCount = 0;

        // when
        try {
            executedCount++;
            throwIllegalArgumentExceptionWhenHasErrorIsFalse(hasError);
        } catch (IllegalArgumentException e) {
            hasError = true;
        }

        // then
        assertThat(executedCount).isEqualTo(1);
    }

    @DisplayName("함수를 재귀하여 예외가 발생하지 않을 때 까지 반복할 수 있다.")
    @Test
    void recursivelyRepeatFunctionUntilNoError() {
        // given
        boolean hasError = false;
        boolean isSuccess = false;

        // when
        try {
            isSuccess = returnTrueWhenSuccessOrThrowException(hasError);
        } catch (IllegalArgumentException e) {
            hasError = true;
            isSuccess = returnTrueWhenSuccessOrThrowException(hasError);
        }

        // then
        assertThat(isSuccess).isEqualTo(true);
    }

    @DisplayName("반목문을 사용해 예외가 발생하지 않을 때 까지 반복할 수 있다.")
    @Test
    void repeatWithLoopUntilNoException() {
        // given
        boolean hasError = false;
        boolean isSuccess = false;

        // when
        while (true) {
            try {
                isSuccess = returnTrueWhenSuccessOrThrowException(hasError);
                break;
            } catch (IllegalArgumentException e) {
                hasError = true;
            }
        }

        // then
        assertThat(isSuccess).isEqualTo(true);
    }

    boolean returnTrueWhenSuccessOrThrowException(boolean hasError) {
        throwIllegalArgumentExceptionWhenHasErrorIsFalse(hasError);
        return true;
    }

    void throwIllegalArgumentExceptionWhenHasErrorIsFalse(boolean hasError) {
        if (!hasError) {
            throw new IllegalArgumentException("예외 발생");
        }
    }

    @DisplayName("함수형 인터페이스를 이용해 매개변수로 받은 메소드를 예외가 발생하지 않을 떄 까지 반복할 수 있다.")
    @Test
    void usingFunctionalInterfaceCanRepeatGivenMethodUntilNoException() {
        // given
        boolean hasError = false;

        // when
        boolean result
            = executeWithExceptionHandle(() -> returnTrueWhenRandomValueIsOne());

        // then
        assertThat(result).isEqualTo(true);
    }

    <T> T executeWithExceptionHandle(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                // log
            }
        }
    }

    boolean returnTrueWhenRandomValueIsOne() {
        int value = Randoms.pickNumberInRange(0, 100);
        if (value == 1) {
            return true;
        }
        throw new IllegalArgumentException("에러 발생");
    }
}
