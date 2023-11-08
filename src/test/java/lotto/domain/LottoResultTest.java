package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoResultTest {
    @DisplayName("enum의 상수 중 matchedNumbers가 로또 결과에 알맞게 매치되는지 테스트한다.")
    @Test
    void testGetMatchedNumbers() {
        LottoResult result = LottoResult.MATCH_4;

        int matchedNumbers = result.getMatchedNumbers();

        assertEquals(4, matchedNumbers);
    }

    @DisplayName("enum의 상수 중 prize가 로또 결과에 알맞게 매치되는지 테스트한다.")
    @Test
    void testGetPrize() {
        LottoResult result = LottoResult.MATCH_5_WITH_BONUS;

        int prize = result.getPrize();

        assertEquals(30000000, prize);
    }

    @DisplayName("enum의 상수 중 description가 로또 결과에 알맞게 매치되는지 테스트한다.")
    @Test
    void testGetResultDescription() {
        LottoResult result = LottoResult.MATCH_3;

        String description = result.getResultDescription(2);

        assertEquals("3개 일치 (5,000원) - 2개", description);
    }

    @DisplayName("로또 5개 일치&&보너스 번호 일치할 경우의 로직이 정확한지 테스트한다.")
    @Test
    void testIsBonusMatch() {
        LottoResult result = LottoResult.MATCH_5;
        boolean bonusMatch = true;

        boolean isBonusMatch = result.isBonusMatch(bonusMatch);

        assertTrue(isBonusMatch);
    }
}
