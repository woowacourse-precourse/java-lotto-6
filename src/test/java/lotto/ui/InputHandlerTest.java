package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.Mockito.mockStatic;

class InputHandlerTest {

    @DisplayName("10만원 이하의 1,000원 단위의 값이 입력되면 정상 처리된다.")
    @Test
    void getValidPurchaseAmount() {
        try (MockedStatic<Console> mocked = mockStatic(Console.class)) {
            mocked.when(Console::readLine).thenReturn("3000");

            OutputHandler outputHandler = new OutputHandler();
            InputHandler inputHandler = new InputHandler(outputHandler);

            Assertions.assertThat(inputHandler.getValidPurchaseAmountFromUser())
                    .isEqualTo(3000);

        }
    }

    @DisplayName("양의 정수가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void whenNotPositiveIntegerAreGiven_throwIlleagalArgumentException() {
        try (MockedStatic<Console> mocked = mockStatic(Console.class)) {
            mocked.when(Console::readLine).thenReturn("-1");

            OutputHandler outputHandler = new OutputHandler();
            InputHandler inputHandler = new InputHandler(outputHandler);

            Assertions.assertThatThrownBy(inputHandler::getValidPurchaseAmountFromUser)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 양의 정수만 입력해야 합니다.");

        }
    }

    @DisplayName("1000원 단위가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void whenNotThousandUnitsAreGiven_throwIlleagalArgumentException() {
        try (MockedStatic<Console> mocked = mockStatic(Console.class)) {
            mocked.when(Console::readLine).thenReturn("1234");

            OutputHandler outputHandler = new OutputHandler();
            InputHandler inputHandler = new InputHandler(outputHandler);

            Assertions.assertThatThrownBy(inputHandler::getValidPurchaseAmountFromUser)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 1,000 단위로 입력해야 합니다.");

        }
    }

    @DisplayName("10만원 초과 구매시 예외가 발생한다.")
    @Test
    void whenTooMuchAreGiven_throwIlleagalArgumentException() {
        try (MockedStatic<Console> mocked = mockStatic(Console.class)) {
            mocked.when(Console::readLine).thenReturn("1000000");

            OutputHandler outputHandler = new OutputHandler();
            InputHandler inputHandler = new InputHandler(outputHandler);

            Assertions.assertThatThrownBy(inputHandler::getValidPurchaseAmountFromUser)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 10만원을 초과해서 구매할 수 없습니다.");

        }
    }
}