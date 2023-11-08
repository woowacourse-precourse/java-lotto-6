package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningTest {
    private LottoWinning winning;

    @DisplayName("총상금 계산")
    @Test
    public void testCalculatePrizeMoney() {
        LottoWinning winning = new LottoWinning();
        int prize = 5000;
        int result = 2;
        int totalPrize = winning.calculatePrizeMoney(prize, result);
        assertEquals(totalPrize, 10000);
    }

    @DisplayName("수익률 계산")
    @Test
    public void testCalculateEarningRate() {
        LottoWinning winning = new LottoWinning();
        int amount = 10000;
        int prizeMoney = 20000;
        double totalRate = winning.calcualteEarningRate(amount, prizeMoney);
        assertEquals(totalRate, 200);
    }
}