package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStaticsTest {

    @DisplayName("당첨 등수들을 바탕으로 당첨 등수의 갯수를 저장하는 기능")
    @Test
    void winningRankStoreTest() {
        //given
        List<Rank> winningRanks = List.of(Rank.FIRST, Rank.SECOND, Rank.FOURTH);
        //when
        WinningStatistics statistics = WinningStatistics.from(winningRanks);
        //then
        assertThat(statistics.showCountOf(Rank.FIRST)).isEqualTo(1);
        assertThat(statistics.showCountOf(Rank.FOURTH)).isEqualTo(1);
        assertThat(statistics.showCountOf(Rank.SECOND)).isEqualTo(1);
        assertThat(statistics.showCountOf(Rank.THIRD)).isEqualTo(0);


    }


}
