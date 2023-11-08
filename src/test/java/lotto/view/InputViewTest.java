package lotto.view;

import lotto.util.Constants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {
    private final InputView inputView = new InputView();

    @Test
    void turnToInteger() {
        Assertions.assertThat(inputView.turnToInteger("3000")).isEqualTo(3000);
    }

    @Test
    void turnToInteger2() {
        Assertions.assertThatThrownBy(() -> inputView.turnToInteger("3000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_INTEGER_TYPE_ERROR);
    }

    @ParameterizedTest
    @CsvSource({"0", "-1000", "-1234"})
    void validateInputBudget(int money) {
        Assertions.assertThatThrownBy(() -> inputView.validateInputBudget(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_LOTTO_BUDGET_RANGE);
    }

    @Test
    void validateInputBudget2() {
        Assertions.assertThatThrownBy(() -> inputView.validateInputBudget(1234))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.ERROR_LOTTO_BUDGET_PRICE);
    }
}