package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.function.Supplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetryExecutorTest {
    public static final int RETURN_VALUE = 42;

    private Supplier<Integer> successfulAction;
    private Supplier<Integer> exceptionAction;

    @BeforeEach
    void setUp() {
        // Mocking 즉시 성공
        successfulAction = mock(Supplier.class);
        when(successfulAction.get()).thenReturn(42);

        // Mocking 3번 예외 후 성공
        exceptionAction = mock(Supplier.class);
        when(exceptionAction.get())
                .thenThrow(new RuntimeException("Test exception"))
                .thenThrow(new RuntimeException("Test exception"))
                .thenThrow(new RuntimeException("Test exception"))
                .thenReturn(RETURN_VALUE); // 4번째 호출에서 정상 값을 반환
    }

    @DisplayName("작업이 예외 없이 성공적으로 완료된다.")
    @Test
    void executeSuccessfulAction() {
        int result = RetryExecutor.execute(successfulAction, RuntimeException.class);

        assertThat(result).isEqualTo(RETURN_VALUE);
    }

    @DisplayName("작업 중 예외가 발생하고, 해당 예외가 지정된 예외 클래스 목록에 속하지 않는 경우에 예외가 발생한다.")
    @Test
    void executeExceptionActionWithoutMatchingException() {
        assertThatThrownBy(() -> RetryExecutor.execute(exceptionAction, IllegalArgumentException.class))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Test exception");
    }

    @DisplayName("작업 중 예외가 발생하고, 해당 예외가 지정된 예외 클래스 목록에 속하는 경우에 예외가 발생하지 않을 때까지 반복 실행한다.")
    @Test
    void executeExceptionActionWithMatchingException() {
        int result = RetryExecutor.execute(exceptionAction, RuntimeException.class);

        assertThat(result).isEqualTo(RETURN_VALUE);
    }
}
