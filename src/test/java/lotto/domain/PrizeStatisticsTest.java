package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeStatisticsTest {

    private PrizeStatistics prizeStatistics;

    @BeforeEach
    void setUp() {
        prizeStatistics = new PrizeStatistics();
    }

    @DisplayName("당첨 통계는 모든 상금에 대해 0으로 초기화되어야 한다.")
    @Test
    void testPrizeStatisticsInitialization() {
        for (Prize prize : Prize.values()) {
            assertThat(prizeStatistics.getCountForPrize(prize)).isEqualTo(0);
        }
    }

    @DisplayName("당첨 통계 업데이트 검증")
    @Test
    void testPrizeStatisticsIncrement() {
        prizeStatistics.updatePrizeStatistics(Prize.FIFTH);
        prizeStatistics.updatePrizeStatistics(Prize.FIFTH);
        prizeStatistics.updatePrizeStatistics(Prize.FIFTH);

        assertThat(prizeStatistics.getCountForPrize(Prize.FIFTH)).isEqualTo(3);
    }

    @DisplayName("전체 당첨 금액 계산 검증")
    @Test
    void testCalculationOfWinningAmount() {
        prizeStatistics.updatePrizeStatistics(Prize.FIRST);
        prizeStatistics.updatePrizeStatistics(Prize.THIRD);

        long expectedWinningAmount = Prize.FIRST.getPrizeMoney() + Prize.THIRD.getPrizeMoney();

        assertThat(prizeStatistics.calculateWinningAmount()).isEqualTo(expectedWinningAmount);
    }


}