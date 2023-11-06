package lotto;

import lotto.domain.Budget;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BudgetTest {
    @DisplayName("금액이 숫자가 아니라면 예외가 발생한다.")
    @Test
    void createBudgetNotNumberic() {
        Assertions.assertThatThrownBy(() -> Budget.from("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원 이하라면 예외가 발생한다.")
    @Test
    void createBudgetLowerThanMinimumPrice() {
        Assertions.assertThatThrownBy(() -> Budget.from("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void createMoneyOfDivideResultNotZero() {
        Assertions.assertThatThrownBy(() -> Budget.from("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
