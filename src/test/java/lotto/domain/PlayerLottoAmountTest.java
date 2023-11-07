package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerLottoAmountTest {
    @Test
    void 금액을_1000으로나눈_amount구하기() {
        PlayerLottoAmount playerLottoAmount = new PlayerLottoAmount("5000");
        int result = playerLottoAmount.calculateLottoCount();
        Assertions.assertThat(result).isEqualTo(5);
    }
}