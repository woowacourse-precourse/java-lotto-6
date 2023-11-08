package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.message.exception.WinningCombinationInputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewBonusNumberTest {
    private InputView inputView = new InputView();

    void setUp(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
    @DisplayName("InputBonusNumber에 숫자를 넣으면 예외 출력 없이 그대로 입력되는지 확인")
    @Test
    void createInputRightBonusNumber() {
        String expectedBudget = "45";
        setUp(expectedBudget);

        String testResult = inputView.InputBonusNumber();
        assertThat(testResult)
                .isEqualTo(expectedBudget);
        Console.close();
    }

    @DisplayName("InputBonusNumber에서 숫자를 넣지 않았을 때 예외 발생")
    @Test
    void createInputBudgetNotNumber(){
        String expectedBudget = "aaa";
        setUp(expectedBudget);

        assertThatThrownBy(inputView::InputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.NOT_NUMBER_BONUS_NUMBER.getMessage());
        Console.close();

    }

    @DisplayName("InputBonusNumber에서 아무것도 입력하지 않았을 때 예외 발생")
    @Test
    void createInputBudgetEmpty() {
        String expectedBudget = "\n";
        setUp(expectedBudget);

        assertThatThrownBy(inputView::InputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.NOT_NUMBER_BONUS_NUMBER.getMessage());
        Console.close();

    }

    @DisplayName("InputBonusNumber에 소수를 적었을 때 예외 발생")
    @Test
    void createInputBudgetPrimeNumber() {
        String expectedBudget = "10000.11";
        setUp(expectedBudget);

        assertThatThrownBy(inputView::InputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.NOT_NUMBER_BONUS_NUMBER.getMessage());
        Console.close();
    }
}