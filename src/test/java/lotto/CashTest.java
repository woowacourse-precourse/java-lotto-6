package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Cash;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinTest {
    private final int MINIMUM_AMOUNT_UNIT = 1000;

    @DisplayName("로또 최소 구입액수인 1000원을 넘어야한다.")
    @Test
    void createCoinByUnderMinimumAmount() {
        assertThatThrownBy(() -> new Cash(MINIMUM_AMOUNT_UNIT - 100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액은 1000으로 나누어 떨어져야 한다.")
    @Test
    void createCoinByIndivisibleMinimumUnit() {
        assertThatThrownBy(() -> new Cash(MINIMUM_AMOUNT_UNIT + 100))
                .isInstanceOf(IllegalArgumentException.class);
    }



}