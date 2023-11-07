package lotto.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @DisplayName("상금 formatter가 정상 작동하는지 테스트")
    @Test
    void formatterTest() {
        assertEquals("2,000,000,000", Rank.FIRST.getFormattedPrize());
        assertEquals("30,000,000", Rank.SECOND.getFormattedPrize());
        assertEquals("1,500,000", Rank.THIRD.getFormattedPrize());
        assertEquals("50,000", Rank.FOURTH.getFormattedPrize());
        assertEquals("5,000", Rank.FIFTH.getFormattedPrize());
    }
}
