package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Rank;
import lotto.domain.WinningStatistic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticTest {
    @DisplayName("총 당첨금액을 계산한다.")
    @Test
    void calculateTotalPrize() {
        List<Rank> ranks = List.of(Rank.FIRST, Rank.FOURTH, Rank.FIFTH);
        WinningStatistic winningStatistic = new WinningStatistic(ranks);

        long result = winningStatistic.calculateTotalPrize();
        long expected = Rank.FIRST.getPrizeMoney() + Rank.FOURTH.getPrizeMoney() + Rank.FIFTH.getPrizeMoney();

        assertThat(result).isEqualTo(expected);
    }
}
