package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMoneyTest {
    @Test
    @DisplayName("로또 구입 금액은 0이 아니여야 한다.")
    void zeroLottoMoney() {
        assertThatThrownBy(() -> new LottoMoney(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액이 1000원으로 나누어지지 않으면 예외가 발생한다.")
    void divideLottoMoney(){
        assertThatThrownBy(() -> new LottoMoney(1200))
                .isInstanceOf(IllegalArgumentException.class);
    }
}