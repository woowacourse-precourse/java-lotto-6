package lotto.domain.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RateResultTest {
    private RateResult rateResult;

    @BeforeEach
    void setUp() {
        rateResult = new RateResult();
    }

    @Test
    void calculate() {
        // given
        Integer useMoney = 8000;
        Integer totalWinMoney = 5000;

        // when
        Double result = rateResult.calculateRate(useMoney, totalWinMoney);

        // than
        assertThat(result).isEqualTo(62.5);
    }

    @DisplayName("수익률을 알려준다.")
    @ParameterizedTest
    @CsvSource({"1000,5000", "2000,5000", "3000,5000", "4000,5000", "5000,5000"})
    void giveRateResult(Integer useMoney, Integer totalWinMoney) {
        // given
        Double rate = ((double) totalWinMoney / useMoney) * 100;
        Double target = Math.round(rate * 10) / 10.0;

        // when
        StringBuilder result = rateResult.giveRateResult(useMoney, totalWinMoney);

        // than
        assertThat(result).contains("총 수익률은 " + target + "%입니다.");
    }
}