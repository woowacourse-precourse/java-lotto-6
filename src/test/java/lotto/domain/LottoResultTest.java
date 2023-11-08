package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoResultTest {
    @Test
    void testGetMatchedNumbers() {
        LottoResult result = LottoResult.MATCH_4;

        int matchedNumbers = result.getMatchedNumbers();

        assertEquals(4, matchedNumbers);
    }

    @Test
    void testGetPrize() {
        LottoResult result = LottoResult.MATCH_5_WITH_BONUS;

        int prize = result.getPrize();

        assertEquals(30000000, prize);
    }

    @Test
    void testGetResultDescription() {
        LottoResult result = LottoResult.MATCH_3;

        String description = result.getResultDescription(2);

        assertEquals("3개 일치 (5,000원) - 2개", description);
    }

    @Test
    void testIsBonusMatch() {
        LottoResult result = LottoResult.MATCH_5;
        boolean bonusMatch = true;

        boolean isBonusMatch = result.isBonusMatch(bonusMatch);

        assertTrue(isBonusMatch);
    }
}
