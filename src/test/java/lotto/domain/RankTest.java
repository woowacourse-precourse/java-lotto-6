package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    @DisplayName("로또 번호와 당첨 번호와의 매치된 수에 맞는 순위를 가져온다.")
    @Test
    void getRankAsMatchCount() {
        // given
        int matchCount = 5;
        boolean matchBonus = true;

        // when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        // then
        assertEquals(Rank.SECOND, rank);
    }
}
