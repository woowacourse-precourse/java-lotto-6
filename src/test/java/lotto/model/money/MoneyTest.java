package lotto.model.money;

import static lotto.exception.ExceptionMessage.MONEY_OUR_RANGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    int validAmount = 1000;
    int invalidAmount = -10;

    @DisplayName("돈은 양수일 때만 생성할 수 있다.")
    @Test
    void inValidMoneyTest() {
        // given
        int amount = invalidAmount;

        // when, then
        assertThatThrownBy(() -> Money.of(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MONEY_OUR_RANGE.getMessage());
    }

}