package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WinningStatisticTest {
    @Test
    void 당첨_통계가_잘나오는지_5개_일치_보너스() {
        //given
        int matchingCount = 5;
        boolean containBonusBall = true;
        //when
        WinningStatistics winningStatistics = WinningStatistics.getStatistic(matchingCount, containBonusBall);
        //then
        Assertions.assertThat(winningStatistics).isEqualTo(WinningStatistics.FIVE_MATCH_BONUS);
    }

    @Test
    void 당첨_통계가_잘나오는지_5개_일치만() {
        //given
        int matchingCount = 5;
        boolean containBonusBall = false;
        //when
        WinningStatistics winningStatistics = WinningStatistics.getStatistic(matchingCount, containBonusBall);
        //then
        Assertions.assertThat(winningStatistics).isEqualTo(WinningStatistics.FIVE_MATCH);
    }

}
