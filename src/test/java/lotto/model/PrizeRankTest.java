package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class PrizeRankTest {

    @DisplayName("6개의 번호가 일치했을때 1등이 됩니다")
    @Test
    void sixMatchingNumbers() {
        assertEquals(PrizeRank.FIRST, PrizeRank.valueOf(6, false));
    }

    @DisplayName("5개의 번호와 보너스 번호가 일치했을때 2등이 됩니다")
    @Test
    void fiveMatchingNumbersWithBonusNumber() {
        assertEquals(PrizeRank.SECOND, PrizeRank.valueOf(5, true));
    }

    @DisplayName("5개의 번호가 일치했을때 3등이 됩니다")
    @Test
    void fiveMatchingNumbers() {
        assertEquals(PrizeRank.THIRD, PrizeRank.valueOf(5, false));
    }

    @DisplayName("4개의 번호가 일치했을때 4등이 됩니다")
    @Test
    void fourMatchingNumbers() {
        assertEquals(PrizeRank.FOURTH, PrizeRank.valueOf(4, false));
    }

    @DisplayName("3개의 번호가 일치했을때 5등이 됩니다")
    @Test
    void threeMatchingNumbers() {
        assertEquals(PrizeRank.FIFTH, PrizeRank.valueOf(3, false));
    }

    @DisplayName("3개 미만의 번호가 일치했을때는 상금이 없습니다")
    @Test
    void underThreeMatchingNumbers() {
        assertEquals(PrizeRank.NONE, PrizeRank.valueOf(2, false));
        assertEquals(PrizeRank.NONE, PrizeRank.valueOf(1, false));
        assertEquals(PrizeRank.NONE, PrizeRank.valueOf(0, false));
    }
}
