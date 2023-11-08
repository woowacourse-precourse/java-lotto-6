package lotto.domain;

import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BudgetTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, -100, -200})
    void 음수_예산_미통과(int budget) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Budget(budget);
        }, ErrorMessage.ONLY_ZERO_OR_MORE.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 22000, 43000})
    void 예산_단위_통과(int budget) {
        new Budget(budget);
    }


    @ParameterizedTest
    @ValueSource(ints = {1050, 22500, 1001})
    void 예산_단위_미통과(int budget) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Budget(budget);
        }, ErrorMessage.UNITS_OF_1000.getErrorMessage());
    }

    @Test
    void 이익률_테스트() {
        Budget budget = new Budget(8000);
        org.assertj.core.api.Assertions.assertThat(budget.calProfitRatio(5000))
                .isEqualTo(62.5);
    }
}
