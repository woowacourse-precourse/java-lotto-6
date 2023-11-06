package lotto;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class PromptHandlerTest {
    @Test
    @DisplayName("입력받은 값이 숫자가 아닌 경우 IllegalArgumentException 예외가 발생한다.")
    void input_purchase_amount_string() {
        assertReadLineTest(
                () -> {
                    Assertions.assertThatThrownBy(() -> PromptHandler.inputPurchaseAmount())
                            .isInstanceOf(IllegalArgumentException.class);
                },
                "va344-"
        );
    }

    @Test
    @DisplayName("입력받은 값이 int 최대값 보다 클 경우 IllegalArgumentException 예외가 발생한다.")
    void input_purchase_amount_over_maximum_int() {
        assertReadLineTest(
                () -> {
                    Assertions.assertThatThrownBy(() -> PromptHandler.inputPurchaseAmount())
                            .isInstanceOf(IllegalArgumentException.class);
                },
                String.valueOf((long)Integer.MAX_VALUE + 1)
        );
    }

    private void assertReadLineTest(
            final Executable executable,
            final String value
    ) {
        assertConsoleTest(
                Console::readLine,
                executable,
                value
        );
    }

    private <T> void assertConsoleTest(
            final MockedStatic.Verification verification,
            final Executable executable,
            final T value
    ) {
        Duration SIMPLE_TEST_TIMEOUT = Duration.ofSeconds(1L);
        assertTimeoutPreemptively(SIMPLE_TEST_TIMEOUT, () -> {
            try (final MockedStatic<Console> mock = Mockito.mockStatic(Console.class)) {
                mock.when(verification).thenReturn(value);
                executable.execute();
            }
        });
    }
}