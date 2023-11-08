package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    public void testGetWinningCount() {
        LottoResult lottoResult = new LottoResult(4, true);
        int winningCount = lottoResult.getWinningCount();
        assertEquals(4, winningCount);
    }
    @Test
    public void testIsBonusMatch() {
        LottoResult lottoResult = new LottoResult(3, false);
        boolean bonusMatch = lottoResult.isBonusMatch();
        assertFalse(bonusMatch);
    }
}