package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
