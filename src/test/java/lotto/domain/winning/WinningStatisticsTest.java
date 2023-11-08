package lotto.domain.winning;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import lotto.domain.amount.Amount;
import lotto.domain.rank.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class WinningStatisticsTest {

    private static final String PROVIDER_PATH = "lotto.domain.winning.provider.WinningStatisticsTestProvider#";

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForWinningStatisticsExceptionTest")
    @DisplayName("당첨 통계의 일치 개수는 목표값과 일치해야 한다.")
    void winningStatisticsRankCountTest(final List<Rank> ranks,
                                        final Amount amount, final Map<Rank, Long> expectedRankCount) {

        final WinningStatistics statistics = new WinningStatistics(ranks, amount);
        final Map<Rank, Long> rankCount = statistics.getRankCount();
        assertThat(rankCount).isEqualTo(expectedRankCount);
    }

    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideValuesForProfitRateExceptionTest")
    @DisplayName("당첨 통계의 수익률은 목표값과 일치해야 한다.")
    void winningStatisticsProfitTest(final List<Rank> ranks,
                                        final Amount amount, final double expectedProfitRate) {

        final WinningStatistics statistics = new WinningStatistics(ranks, amount);
        final double totalProfit = statistics.getProfitRate();
        assertThat(totalProfit).isEqualTo(expectedProfitRate);
    }
}
