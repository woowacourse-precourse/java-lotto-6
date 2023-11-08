package lotto.model.money;

import static lotto.exception.ExceptionMessage.LOTTO_MONEY_OUT_OF_RANGE;
import static lotto.exception.ExceptionMessage.LOTTO_MONEY_UNIT_ERROR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserBudgetTest {

    @DisplayName("사용자 예산은 0원 이상 100,000 이하의 범위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 100_001})
    void testUserBudgetNotInRange(int outOrRange) {
        // given
        int amount = outOrRange;

        // when, then
        assertThatThrownBy(() -> UserBudget.of(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_MONEY_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("사용자 예산이 로또 금액 단위가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {950, 1050, 2500})
    void testUserBudgetNotDividedByUnit(int notUnit) {
        // given
        int amount = notUnit;

        // when, then
        assertThatThrownBy(() -> UserBudget.of(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_MONEY_UNIT_ERROR.getMessage());
    }
}