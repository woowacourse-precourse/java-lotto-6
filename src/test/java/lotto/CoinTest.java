package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.Coin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoinTest {
    private final int MINIMUM_AMOUNT_UNIT = 1000;
    private final int MINIMUM_LOTTO_COUNT = 1;

    @DisplayName("구입 금액이 1000원을 넘지 않으면 예외가 발생한다.")
    @Test
    void createCoinByUnderMinimumAmount() {
        assertThatThrownBy(() -> new Coin(MINIMUM_AMOUNT_UNIT - 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000으로 나뉘지 않으면 예외가 발생한다.")
    @Test
    void createCoinByIndivisibleMinimumUnit() {
        assertThatThrownBy(() -> new Coin(MINIMUM_AMOUNT_UNIT + 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액을 로또 개수로 변환할 수 있다.")
    @Test
    void createCountByCoin() {
        Coin coin = new Coin(MINIMUM_AMOUNT_UNIT);

        assertThat(coin.getCount()).isEqualTo(MINIMUM_LOTTO_COUNT);
    }

}