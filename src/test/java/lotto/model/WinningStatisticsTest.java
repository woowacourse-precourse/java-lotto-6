package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {

    private WinningStatistics winningStatisticsObject;
    private Map<Rank, Integer> winningStatistics;

    @BeforeEach
    void setUp() {
        winningStatistics = new HashMap<>();
        winningStatisticsObject = new WinningStatistics(winningStatistics);
    }

    @DisplayName("당첨 결과를 확인한다.")
    @Nested
    class WinningResult {

        @DisplayName("일치하는 개수가 6개면 1등 당첨이다.")
        @Test
        void checkFirstPlace() {
            winningStatisticsObject.checkWinningResult(6, false);

            assertThat(winningStatistics.get(Rank.FirstPlace)).isEqualTo(1);
        }

        @DisplayName("일치하는 개수가 5개이고 보너스 번호가 일치하면 2등 당첨이다.")
        @Test
        void checkSecondPlace() {
            winningStatisticsObject.checkWinningResult(5, true);

            assertThat(winningStatistics.get(Rank.SecondPlace)).isEqualTo(1);
        }

        @DisplayName("일치하는 개수가 5개이고 보너스 번호가 일치하지 않으면 3등 당첨이다.")
        @Test
        void checkThirdPlace() {
            winningStatisticsObject.checkWinningResult(5, false);

            assertThat(winningStatistics.get(Rank.ThirdPlace)).isEqualTo(1);
        }

        @DisplayName("일치하는 개수가 4개면 4등 당첨이다.")
        @Test
        void checkFourthPlace() {
            winningStatisticsObject.checkWinningResult(4, false);

            assertThat(winningStatistics.get(Rank.FourthPlace)).isEqualTo(1);
        }

        @DisplayName("일치하는 개수가 3개면 5등 당첨이다.")
        @Test
        void checkFifthPlace() {
            winningStatisticsObject.checkWinningResult(3, false);

            assertThat(winningStatistics.get(Rank.FifthPlace)).isEqualTo(1);
        }
    }

    @DisplayName("당첨금을 모두 합한 총액을 구한다.")
    @Test
    void getTotalWinningAmount() {
        winningStatisticsObject.checkWinningResult(6, false);
        winningStatisticsObject.checkWinningResult(5, true);
        winningStatisticsObject.checkWinningResult(5, false);
        winningStatisticsObject.checkWinningResult(4, false);
        winningStatisticsObject.checkWinningResult(3, false);

        assertThat(winningStatisticsObject.getTotalWinningAmount()).isEqualTo(2031555000);
    }
}
