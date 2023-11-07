package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.constants.Prize;
import org.junit.jupiter.api.Test;

class RateOfReturnTest {
    RateOfReturn rate = new RateOfReturn();
    @Test
    void name() {
        double rateOfReturn = rate.calculate(5_000, 8_000);
        assertThat(rateOfReturn).isEqualTo(62.5);
    }

    @Test
    void sumPrizeMoneyTest() {
        long totalPrizeMoney = rate.sumPrizeMoney(
                Map.of(
                        1, 0,
                        2, 1,
                        3, 1,
                        4, 0,
                        5, 0
                ) // key: 등수 , value: 당첨 개수
        );
        assertThat(totalPrizeMoney)
                .isEqualTo(
                        2_000_000_000 * 0 +
                        30_000_000 * 1 +
                        1_500_000 * 1 +
                        50_000 * 0 +
                        5_000 * 0
                ); // 등수별 상금 * 당첨 개수를 모두 합한 값
    }

    @Test
    void DF() {
        System.out.println(rate.applyDecimalPlace(4.08));
    }
}