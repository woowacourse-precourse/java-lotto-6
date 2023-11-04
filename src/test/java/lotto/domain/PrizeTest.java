package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @Test
    @DisplayName("일치하는 번호가 없을 때 NONE 반환")
    void returnNoneForNoMatches() {
        assertEquals(Prize.NONE, Prize.valueOf(0, false));
    }

    @Test
    @DisplayName("3개 일치할 때 THREE_MATCH 반환")
    void returnThreeMatchForThreeMatches() {
        assertEquals(Prize.THREE_MATCH, Prize.valueOf(3, false));
    }

    @Test
    @DisplayName("보너스 번호가 일치할 때 FIVE_WITH_BONUS 반환")
    void returnFiveWithBonusForFiveMatchesAndBonus() {
        assertEquals(Prize.FIVE_WITH_BONUS, Prize.valueOf(5, true));
    }

    @Test
    @DisplayName("6개 일치할 때 SIX_MATCH 반환")
    void returnSixMatchForSixMatches() {
        assertEquals(Prize.SIX_MATCH, Prize.valueOf(6, false));
    }
}