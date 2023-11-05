package lotto.model;

import lotto.model.Rank;
import lotto.model.RankCounter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankCounterTest {

    @DisplayName("랭크 카운트를 추가한다.")
    @Test
    void 랭크_카운트_추가() {
        // given
        RankCounter rankCounter = RankCounter.create();
        Rank rank = Rank.FIRST;

        // when
        rankCounter.addRank(rank);

        // then
        assertEquals(1, rankCounter.getRankCount(rank));
    }
}
