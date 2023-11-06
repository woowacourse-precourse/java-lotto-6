package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {

    @DisplayName("맞춘 숫자의 개수에 따른 결과 확인")
    @Test
    public void testValueOf() {

        assertEquals(LottoResult.NONE, LottoResult.valueOf(2, false));
        assertEquals(LottoResult.THREE, LottoResult.valueOf(3, false));
        assertEquals(LottoResult.FOUR, LottoResult.valueOf(4, false));
        assertEquals(LottoResult.FIVE, LottoResult.valueOf(5, false));
        assertEquals(LottoResult.FIVE_WITH_BONUS, LottoResult.valueOf(5, true));
        assertEquals(LottoResult.SIX, LottoResult.valueOf(6, false));
    }
    @DisplayName("잘못된 숫자의 개수를 입력했을 때의 예외 처리")
    @Test
    public void testValueOfWithInvalidMatchCount() {
        assertThrows(IllegalArgumentException.class, () -> LottoResult.valueOf(7, false));
        assertThrows(IllegalArgumentException.class, () -> LottoResult.valueOf(-1, false));
    }

    @DisplayName("당첨 금액 확인")
    @Test
    public void testGetPrice() {
        assertEquals(5000, LottoResult.THREE.getPrice());
        assertEquals(50000, LottoResult.FOUR.getPrice());
        assertEquals(1500000, LottoResult.FIVE.getPrice());
        assertEquals(30000000, LottoResult.FIVE_WITH_BONUS.getPrice());
        assertEquals(2000000000, LottoResult.SIX.getPrice());
    }

}