package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRankTest {

    @DisplayName("당첨 번호 매칭 개수에 맞는 순위를 반환하는지 확인한다.")
    @Test
    void testIsMatch() {
        assertTrue(LottoRank.RANK1.isMatch(6, 0));
        assertTrue(LottoRank.RANK2.isMatch(5, 1));
        assertFalse(LottoRank.RANK1.isMatch(5, 1));
        assertFalse(LottoRank.RANK2.isMatch(4, 1));
    }

    @DisplayName("순위에 맞는 설명을 출력하는지 확인한다.")
    @Test
    void testPrintStatus() {
        assertEquals("6개 일치 (2,000,000,000원)", LottoRank.RANK1.printStatus());
        assertEquals("5개 일치, 보너스 볼 일치 (30,000,000원)", LottoRank.RANK2.printStatus());
    }

    @DisplayName("순위에 맞는 금액을 출력하는지 확인한다.")
    @Test
    void testGetPrize() {
        assertEquals(2000000000, LottoRank.RANK1.getPrize());
        assertEquals(30000000, LottoRank.RANK2.getPrize());
    }
}
