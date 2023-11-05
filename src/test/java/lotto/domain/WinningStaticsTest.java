package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStaticsTest {

    List<Rank> winningRanks;

    @BeforeEach
    void initWinningRanks() {
        //given
        winningRanks = List.of(Rank.FIRST, Rank.SECOND, Rank.FOURTH);
    }

    @DisplayName("당첨 등수들을 바탕으로 당첨 등수의 갯수를 저장하는 기능")
    @Test
    void winningRankStoreTest() {

        //when
        WinningStatistics statistics = WinningStatistics.from(winningRanks);
        //then
        assertThat(statistics.showCountOf(Rank.FIRST)).isEqualTo(1);
        assertThat(statistics.showCountOf(Rank.FOURTH)).isEqualTo(1);
        assertThat(statistics.showCountOf(Rank.SECOND)).isEqualTo(1);
        assertThat(statistics.showCountOf(Rank.THIRD)).isEqualTo(0);

    }

    @DisplayName("당첨 등수들을 바탕으로 총 수익을 산출하는기능")
    @Test
    void revenueCalculationTest() {
        //when
        WinningStatistics winningStatistics = WinningStatistics.from(winningRanks);
        //then
        long expectedValue = 2030050000L;
        assertThat(winningStatistics.showRevenue()).isEqualTo(expectedValue);

    }





}
