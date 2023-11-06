package lotto;

import lotto.domain.Budget;
import lotto.domain.Lotto;
import lotto.view.message.exception.BudgetInputErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BudgetTest {

    @DisplayName("구입금액이 1000원 미만일 때 예외 발생")
    @Test
    void budgetLessThan1000() {
        Budget budget;
        assertThatThrownBy(() -> new Budget("100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BudgetInputErrorMessage.LESS_THAN_1000.getMessage());
    }

    @DisplayName("구입금액이 1000으로 나누어 떨어지지 않을 때 예외 발생")
    @Test
    void budgetNotDivisible1000(){
        Budget budget;
        assertThatThrownBy(() -> new Budget("3333"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BudgetInputErrorMessage.DIVISIBLE_BY_THOUSAND.getMessage());
    }
}