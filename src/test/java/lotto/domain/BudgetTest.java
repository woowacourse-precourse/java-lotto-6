package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BudgetTest {
    @Test
    @DisplayName("로또 구입 금액 - 정상 입력")
    void normalBudgetTest() {
        int money = 1000;
        Budget budget = new Budget(money);
        assertThat(budget.getMoney()).isEqualTo(money);
    }

    @Test
    @DisplayName("로또 구입 금액 - 0 이하의 수 입력")
    void zeroOrNegativeBudgetTest() {
        int money = -1000;
        assertThatThrownBy(() -> new Budget(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("로또 구입 금액 - 단위금액으로 나눠지지 않는 수 입력")
    void notMultipleOfUnitPriceBudgetTest() {
        int money = 1500;
        assertThatThrownBy(() -> new Budget(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
