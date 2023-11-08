package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RankTest {

    @Test
    @DisplayName("6개 번호 일치 시 1등 반환")
    void testFirstRank() {
        assertEquals(Rank.FIRST, Rank.valueOf(6, false));
    }

    @Test
    @DisplayName("5개 번호와 보너스 번호 일치 시 2등 반환")
    void testSecondRank() {
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
    }

    @Test
    @DisplayName("5개 번호 일치 시 3등 반환")
    void testThirdRank() {
        assertEquals(Rank.THIRD, Rank.valueOf(5, false));
    }

    @Test
    @DisplayName("4개 번호 일치 시 4등 반환")
    void testFourthRank() {
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
    }

    @Test
    @DisplayName("3개 번호 일치 시 5등 반환")
    void testFifthRank() {
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
    }

    @Test
    @DisplayName("2개 이하 번호 일치 시 등수 없음 반환")
    void testNoRank() {
        assertEquals(Rank.NONE, Rank.valueOf(2, false));
        assertEquals(Rank.NONE, Rank.valueOf(1, false));
        assertEquals(Rank.NONE, Rank.valueOf(0, false));
    }
}
