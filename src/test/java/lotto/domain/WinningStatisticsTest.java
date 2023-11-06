package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constants.WinningCriteria;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("당첨결과가 정상적으로 업데이트 된다.")
    @Test
    void shouldAddResult() {
        int expectedValue = 1;
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.addResult(WinningCriteria.FIRST);
        assertThat(winningStatistics.getWinningInfo().get(WinningCriteria.FIRST)).isEqualTo(expectedValue);
    }

    @DisplayName("전체 당첨금액을 계산한다.")
    @Test
    void shouldCalculateTotalPrizeAmount() {
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.addResult(WinningCriteria.FIRST);
        winningStatistics.addResult(WinningCriteria.SECOND);
        winningStatistics.addResult(WinningCriteria.THIRD);

        int totalPrizeAmount = winningStatistics.calculateTotalPrizeAmount();
        assertThat(WinningCriteria.FIRST.getPrizeAmount() + WinningCriteria.SECOND.getPrizeAmount() +
                WinningCriteria.THIRD.getPrizeAmount()).isEqualTo(totalPrizeAmount);
    }

    @DisplayName("처음 객체가 만들어질때 초기화가 잘 된다.")
    @Test
    void shouldInitializeWinningInfo() {
        int expectedValue = 0;
        WinningStatistics winningStatistics = new WinningStatistics();
        assertThat(winningStatistics.calculateTotalPrizeAmount()).isEqualTo(expectedValue);
        for (WinningCriteria criteria : WinningCriteria.values()) {
            assertThat(winningStatistics.getWinningInfo().get(criteria)).isEqualTo(expectedValue);
        }
    }
}
