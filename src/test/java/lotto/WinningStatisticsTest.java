package lotto;

import static lotto.domain.Ranking.THREE_MATCHES;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {
    @Test
    @DisplayName("해당하는 당첨 통계의 개수를 증가시키는 테스트")
    void incrementWinningStatus_test(){
        WinningStatistics winningStatisticsTest = new WinningStatistics();

        winningStatisticsTest.incrementWinningStatus(THREE_MATCHES);

        assertThat(winningStatisticsTest.getWinningStatus().get(THREE_MATCHES)).isEqualTo(1);
    }
}
