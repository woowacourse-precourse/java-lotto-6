package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoReturnRateTest {

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculateReturnRate() {
        LottoReturnRate returnRate = new LottoReturnRate(8000);
        returnRate.calculateReturnRate(5000);
        assertThat(returnRate.getReturnRate()).isEqualTo(62.5);
    }
}