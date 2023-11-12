package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class WinningStatisticsTest {
    @Test
    @DisplayName("quantity가 1이면 당첨금액은 해당 statistics의 money 같아야한다.")
    void produce_statistic_based_result() {
        int quantity = 1;
        List<Integer> winningNumberResult = List.of(Statistics.FOUR_MATCHES.getValue());
        List<Boolean> bonusResult = List.of(Boolean.FALSE);
        ResultDTO resultDTO = new ResultDTO(winningNumberResult, bonusResult);

        WinningStatistics winningStatistics = new WinningStatistics(resultDTO, quantity);

        Assertions.assertThat(winningStatistics.calculatePrizeMoney()).isEqualTo(Statistics.FOUR_MATCHES.getMoney());
    }
}