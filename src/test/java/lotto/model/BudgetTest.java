package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.utils.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BudgetTest {

    @DisplayName("음수인 예산은 예외 처리 된다.")
    @Test
    void validateNonPositiveBudget() {
        int inputMoney = -100;
        assertThatThrownBy(() -> new Budget(inputMoney)).isInstanceOf(
            IllegalArgumentException.class).hasMessage(
            ExceptionMessage.INVALID_BUDGET_NOT_POSITIVE.getMessage());
    }

    @DisplayName("1000으로 나뉘지 않는 예산은 예외 처리 된다.")
    @Test
    void validateNonThousandUnitBudget() {
        int budget = 1234;
        assertThatThrownBy(() -> new Budget(budget))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ExceptionMessage.INVALID_BUDGET_AMOUNT.getMessage());
    }

    @DisplayName("정상 입력")
    @Test
    void validateCorrectBudget() {
        int budget = 20000;
        assertDoesNotThrow(() -> new Budget(budget));
    }
}