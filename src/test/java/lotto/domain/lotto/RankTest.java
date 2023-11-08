package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("로또 등수 확인 테스트 - 1등")
    @Test
    void checkLottoRankTest() {
        // given
        int matchCount = 6;
        boolean matchBonus = false;
        // when
        Rank rank = Rank.of(matchCount, matchBonus);
        // then
        assertEquals(Rank.FIRST, rank);
    }

    @DisplayName("로또 등수 확인 테스트 - 3등")
    @Test
    void checkLottoRankTestThird() {
        // given
        int matchCount = 5;
        boolean matchBonus = false;
        // when
        Rank rank = Rank.of(matchCount, matchBonus);
        // then
        assertEquals(Rank.THIRD, rank);
    }

    @DisplayName("로또 등수 확인 테스트 - 꽝")
    @Test
    void checkLottoRankTestMiss() {
        // given
        int matchCount = 2;
        boolean matchBonus = false;
        // when
        Rank rank = Rank.of(matchCount, matchBonus);
        // then
        assertEquals(Rank.MISS, rank);
    }
}