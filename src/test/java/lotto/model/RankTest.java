package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("6 개의 matchCount와 matchBonus 가 false일시 1등")
    @Test
    public void whenMatchSixThenFirst() {
        assertEquals(Rank.FIRST, Rank.valueOf(6, false));
    }

    @DisplayName("5 개의 matchCount와 matchBonus 가 true일시 2등")
    @Test
    public void whenMatchFiveAndBonusThenSecond() {
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
    }

    @DisplayName("5 개의 matchCount와 matchBonus 가 false일시 3등")
    @Test
    public void whenMatchFiveThenThird() {
        assertEquals(Rank.THIRD, Rank.valueOf(5, false));
    }

    @DisplayName("4 개의 matchCount와 matchBonus 가 false일시 4등")
    @Test
    public void whenMatchFourThenFourth() {
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
    }

    @DisplayName("3 개의 matchCount와 matchBonus 가 false일시 5등")
    @Test
    public void whenMatchThreeThenFifth() {
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
    }

    @DisplayName("0,1,2 개의 matchCount와 matchBonus 가 false일시 NONE")
    @Test
    public void whenMatchLessThanThreeThenNone() {
        assertEquals(Rank.NONE, Rank.valueOf(2, false));
        assertEquals(Rank.NONE, Rank.valueOf(1, false));
        assertEquals(Rank.NONE, Rank.valueOf(0, false));
    }
}