package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyerTest {

    @DisplayName("로또 당첨 수익률을 계산합니다.")
    @Test
    void testCalculateReturnRate() {
        int purchaseAmount = 8;
        Buyer kim = new Buyer(purchaseAmount, new LottoMachine());
        long prizeSum = 5000L;

        double result = kim.calculateReturnRate(prizeSum);
        double expected = 62.5;

        assertEquals(expected, result);
    }
}