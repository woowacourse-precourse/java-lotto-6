package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ProfitRateTest {

    @DisplayName("수익률 계산 테스트")
    @ParameterizedTest
    @CsvSource({"5000, 5000", "10000, 5000", "10000, 10000", "10000, 15000"})
    void profitRateTest(int purchaseAmount, int profit) {
        // given & when
        ProfitRate profitRate = new ProfitRate(profit, purchaseAmount);

        double expected = ((double) profit / purchaseAmount) * 100;

        // then
        Assertions.assertThat(profitRate.getProfitRate()).isEqualTo(expected);
    }
}
