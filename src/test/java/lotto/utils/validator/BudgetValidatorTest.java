package lotto.utils.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.utils.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BudgetValidatorTest {

    private BudgetValidator budgetValidator;

    @BeforeEach
    void setUp() {
        budgetValidator = new BudgetValidator();
    }

    @DisplayName("음수인 예산은 예외처리 된다.")
    @Test
    void validateNonIntBudget() {
        int budget = -100;
        assertThatThrownBy(() -> budgetValidator.validate(budget))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ExceptionMessage.INVALID_BUDGET_NOT_POSITIVE.getMessage());
    }

    @DisplayName("1000으로 나뉘지 않는 예산은 예외처리 된다.")
    @Test
    void validateBudget() {
        int budget = 1234;
        assertThatThrownBy(() -> budgetValidator.validate(budget))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ExceptionMessage.INVALID_BUDGET_AMOUNT.getMessage());
    }

    @DisplayName("정상 입력")
    @Test
    void validateCorrectBudget() {
        int budget = 20000;
        assertDoesNotThrow(() -> budgetValidator.validate(budget));
    }

}