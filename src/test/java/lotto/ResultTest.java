package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @DisplayName("등수에 따라 해당 결과값이 1 추가되는 기능")
    @Test
    void 등수_값_추가() {
        //given
        Result result = new Result();
        Rank first = Rank.FIRST;

        //when
        result.addRank(first);

        //then
        assertThat(result.getTotalProfit()).isEqualTo(first.getRankReward(1));
    }
}
