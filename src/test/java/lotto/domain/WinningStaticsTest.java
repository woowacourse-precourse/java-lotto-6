package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

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



    @DisplayName("당첨 등수들을 바탕으로 총 수익을 산출하는기능")
    @Test
    void revenueCalculationTest() {
        //when
        WinningStatistics winningStatistics = WinningStatistics.from(winningRanks);
        //then
        long expectedValue = 2030050000L;
        assertThat(winningStatistics.showRevenue()).isEqualTo(expectedValue);

    }

    @DisplayName("당첨 등수들이 잘 저장되었는지 테스트")
    void ranksStoreTest() {
        WinningStatistics winningStatistics = WinningStatistics.from(winningRanks);

        for (Rank rank : winningRanks) {
            int count = winningStatistics.showCountOf(rank);
            assertThat(count).isEqualTo(1);
        }



    }





}
