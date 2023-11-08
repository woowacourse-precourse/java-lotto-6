package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoMessageTest {
    @DisplayName("로또 메세지 열거형 확인하기")
    @Test
    void testLottoMessage() {
        assertEquals("3개 일치 (5,000원)", LottoMessage.THREE.message);
        assertEquals(5000, LottoMessage.THREE.winningAmount);

        assertEquals("4개 일치 (50,000원)", LottoMessage.FOUR.message);
        assertEquals(50000, LottoMessage.FOUR.winningAmount);

        assertEquals("5개 일치 (1,500,000원)", LottoMessage.FIVE.message);
        assertEquals(1500000, LottoMessage.FIVE.winningAmount);

        assertEquals("5개 일치, 보너스 볼 일치 (30,000,000원)", LottoMessage.BONUS.message);
        assertEquals(30000000, LottoMessage.BONUS.winningAmount);

        assertEquals("6개 일치 (2,000,000,000원)", LottoMessage.SIX.message);
        assertEquals(2000000000, LottoMessage.SIX.winningAmount);
    }
}
