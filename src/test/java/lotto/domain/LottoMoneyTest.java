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
}