package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.message.exception.BudgetInputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewBudgetTest {
    private final InputView inputView = new InputView();

    void setUp(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("정상적인 값이 입력되는 경우 그대로 입력되는지 확인")
    @Test
    void testInputBudgetNumber() {
        String expectedBudget = "1231";
        setUp(expectedBudget);

        String testResult = inputView.InputBudget();
        assertThat(testResult)
                .isEqualTo(expectedBudget);
        Console.close();
    }

    @DisplayName("숫자를 넣지 않았을 때 예외 발생")
    @Test
    void createInputBudgetNotNumber(){
        String expectedBudget = "aaa";
        setUp(expectedBudget);

        assertThatThrownBy(inputView::InputBudget)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BudgetInputErrorMessage.NOT_NUMBER.getMessage());
        Console.close();
    }

    @DisplayName("아무것도 입력하지 않았을 때 예외 발생")
    @Test
    void createInputBudgetEmpty() {
        String expectedBudget = "\n";
        setUp(expectedBudget);

        assertThatThrownBy(inputView::InputBudget)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BudgetInputErrorMessage.NOT_NUMBER.getMessage());
        Console.close();
    }

    @DisplayName("소수를 적었을 때 예외 발생")
    @Test
    void createInputBudgetDouble() {
        String expectedBudget = "10000.11";
        setUp(expectedBudget);

        assertThatThrownBy(inputView::InputBudget)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BudgetInputErrorMessage.NOT_NUMBER.getMessage());
        Console.close();
    }

}