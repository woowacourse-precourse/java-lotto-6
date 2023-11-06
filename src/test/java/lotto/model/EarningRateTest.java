package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class EarningRateTest {

    @Test
    @DisplayName("상품 금액과 로또 금액을 통해 수익률을 계산한다.")
    void calculateEarningRate_getEarningRate() {
        /**
         * given : 총 상품 금액과 로또 금액이 주어진다.
         * when : EarningRate 객체를 생성한다.
         * then : 수익률은 62.5(%)가 나와야 한다.
         */
        double totalPrize = 5000;
        LottoAmount amount = new LottoAmount("8000");

        EarningRate earningRate = new EarningRate(totalPrize, amount);
        double earn = earningRate.getEarningRate();

        assertThat(earn).isEqualTo(62.5);
    }
}