package lotto.enums;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {

    @DisplayName("Rank에 대해 count와 bonus 검증이 잘 되는지 테스트")
    @Test
    void matchBonusTest() {
        assertTrue(Rank.FIRST.isMatchBonus(6, false));
        assertTrue(Rank.SECOND.isMatchBonus(5, true));
        assertTrue(Rank.THIRD.isMatchBonus(5, false));
        assertTrue(Rank.FOURTH.isMatchBonus(4, false));
        assertTrue(Rank.FIFTH.isMatchBonus(3, false));
    }
}
