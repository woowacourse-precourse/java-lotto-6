package lotto.view;

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
    void testInputBonusNumber() {
        String expectedBudget = "45";
        setUp(expectedBudget);

        String testResult = inputView.InputBonusNumber();
        assertThat(testResult)
                .isEqualTo(expectedBudget);
    }

    @DisplayName("InputBonusNumber에서 숫자를 넣지 않았을 경우 예외출력 확인")
    @Test
    void testInputBudgetNotNumber(){
        String expectedBudget = "aaa";
        setUp("aaaa");

        assertThatThrownBy(inputView::InputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.NOT_NUMBER_BONUS_NUMBER.getMessage());

    }

    @DisplayName("InputBonusNumber에서 아무것도 입력하지 않았을 때 예외 출력")
    @Test
    void testInputBudgetEmpty() {
        String expectedBudget = "\n";
        setUp("\n");

        assertThatThrownBy(inputView::InputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.NOT_NUMBER_BONUS_NUMBER.getMessage());

    }

    @DisplayName("InputBonusNumber에 소수를 적었을 때 예외 출력")
    @Test
    void testInputBudgetDouble() {
        String expectedBudget = "10000.11";
        setUp("1000.11");

        assertThatThrownBy(inputView::InputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(WinningCombinationInputErrorMessage.NOT_NUMBER_BONUS_NUMBER.getMessage());
    }
}