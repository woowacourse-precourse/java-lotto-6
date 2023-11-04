package lotto;

import lotto.domain.Budget;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BudgetTest {
    @Test
    void createBudgetNotNumberic(){
        Assertions.assertThatThrownBy(() -> Budget.from("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createBudgetLowerThanMinimumPrice(){
        Assertions.assertThatThrownBy(() -> Budget.from("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createMoneyOfDivideResultNotZero(){
        Assertions.assertThatThrownBy(() -> Budget.from("1100"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
