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
}
