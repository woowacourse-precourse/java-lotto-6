package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {
    @Test
    @DisplayName("일치하는 번호가 없을 때 NONE 반환")
    void returnNone() {
        assertEquals(Prize.NONE, Prize.valueOf(0, false));
    }

    @Test
    @DisplayName("3개 일치할 때 THREE_MATCH 반환")
    void returnThreeMatch() {
        assertEquals(Prize.THREE_MATCH, Prize.valueOf(3, false));
    }

    @Test
    @DisplayName("3개 일치할 때 일치하고 보너스도 일치할 때 THREE_MATCH 반환")
    void returnThreeMatchWithBonus() {
        assertEquals(Prize.THREE_MATCH, Prize.valueOf(3, true));
    }

    @Test
    @DisplayName("4개 일치할 때 일치하고 보너스도 일치할 때 FOUR_MATCH 반환")
    void returnFiveMatchesWithBonus() {
        assertEquals(Prize.FOUR_MATCH, Prize.valueOf(4, true));
    }

    @Test
    @DisplayName("4개 일치할 때 일치할 때 FOUR_MATCH 반환")
    void returnFourMatches() {
        assertEquals(Prize.FOUR_MATCH, Prize.valueOf(4, false));
    }

    @Test
    @DisplayName("5개 일치할 때 일치할 때 FIVE_MATCH 반환")
    void returnFiveMatches() {
        assertEquals(Prize.FIVE_MATCH, Prize.valueOf(5, false));
    }

    @Test
    @DisplayName("보너스 번호가 일치할 때 FIVE_WITH_BONUS 반환")
    void returnFiveWithBonus() {
        assertEquals(Prize.FIVE_WITH_BONUS, Prize.valueOf(5, true));
    }

    @Test
    @DisplayName("6개 일치할 때 SIX_MATCH 반환")
    void returnSixMatch() {
        assertEquals(Prize.SIX_MATCH, Prize.valueOf(6, false));
    }
}