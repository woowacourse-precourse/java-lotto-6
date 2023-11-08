package lotto.domain;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RankResultTest {
    @DisplayName("당첨 내역이 없는 경우")
    @Test
    void calculateRankResultWithNoMatches() {
        // given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)),
                new Lotto(Arrays.asList(21, 22, 23, 24, 25, 26))
        ));
        RankResult rankResult = new RankResult();

        // when
        rankResult.calcRankResult(winningNumber, lottos);

        // then
        assertThat(rankResult.getRankCount(Rank.FIRST)).isEqualTo(0);
        assertThat(rankResult.getRankCount(Rank.SECOND)).isEqualTo(0);
        assertThat(rankResult.getRankCount(Rank.THIRD)).isEqualTo(0);
        assertThat(rankResult.getRankCount(Rank.FOURTH)).isEqualTo(0);
        assertThat(rankResult.getRankCount(Rank.FIFTH)).isEqualTo(0);
        assertThat(rankResult.getRankCount(Rank.NONE)).isEqualTo(2);
    }

    @DisplayName("당첨 내역이 있는 경우")
    @Test
    void calculateRankResultWithMatches() {
        // given
        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), // 당첨 6개 = 1등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), // 당첨 5개 + 보너스 1개 = 2등
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), // 당첨 5개 = 3등
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)), // 당첨 4개 = 4등
                new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10)), // 당첨 3개 = 5등
                new Lotto(Arrays.asList(1, 2, 3, 7, 9, 10)) // 당첨 3개 + 보너스 1개 = 5등
        ));
        RankResult rankResult = new RankResult();

        // when
        rankResult.calcRankResult(winningNumber, lottos);

        // then
        assertThat(rankResult.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(rankResult.getRankCount(Rank.SECOND)).isEqualTo(1);
        assertThat(rankResult.getRankCount(Rank.THIRD)).isEqualTo(1);
        assertThat(rankResult.getRankCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankResult.getRankCount(Rank.FIFTH)).isEqualTo(2);
        assertThat(rankResult.getRankCount(Rank.NONE)).isEqualTo(0);
    }
}
