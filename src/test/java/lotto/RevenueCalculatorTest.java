package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import lotto.model.RevenueCalculator;
import lotto.model.WinningStatistics;
import org.junit.jupiter.api.Test;

public class RevenueCalculatorTest {
    RevenueCalculator revenueCalculator = new RevenueCalculator();

    @Test
    void 수익을_잘구하는지_테스트() {
        // given
        Map<WinningStatistics, Long> winningStatistics = new HashMap<>();
        winningStatistics.put(WinningStatistics.THREE_MATCH, 2L);
        // when
        long earnings = revenueCalculator.calculateEarnings(winningStatistics);
        // then
        assertThat(earnings).isEqualTo(10000L);
    }

    @Test
    void 수익률을_맞게_구하는지_테스트() {
        // given
        int buyPrice = 8000;
        Map<WinningStatistics, Long> winningStatistics = new HashMap<>();
        winningStatistics.put(WinningStatistics.THREE_MATCH, 1L);
        // when
        double earningRate = revenueCalculator.calculateEarningRate(winningStatistics, 8000);
        // then
        assertThat(earningRate).isEqualTo(62.5);
    }
}
