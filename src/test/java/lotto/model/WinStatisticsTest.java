package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinStatisticsTest {

    @DisplayName("당첨금 합이 올바르게 계산되는지")
    @Test
    void verifyTotalPrizeAmountCalculation(){
        WinStatistics result = new WinStatistics();
        double expect = 30005000.0;

        result.pushRank(Rank.FIFTH);
        result.pushRank(Rank.SECOND);

        assertThat(result.sum()).isEqualTo(expect);
    }
}
