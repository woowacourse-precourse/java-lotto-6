package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningResultTest {
    @Test
    void addWinningRank() {
        WinningResult result = new WinningResult();
        result.addWinningRank(Rank.FIRST);
        assertEquals(1, result.getRankCount(Rank.FIRST));
    }

    @Test
    void calculateEarningsRate() {
        WinningResult result = new WinningResult();
        result.addWinningRank(Rank.FIRST);
        double expectedRate = (double) Rank.FIRST.getReward() / 1000 * 100;  // 가정: 로또 1장의 가격이 1000원이라 가정
        assertEquals(expectedRate, result.calculateEarningsRate(1000));
    }

    @Test
    void calculateEarningsRateWithZeroInputMoney() {
        WinningResult result = new WinningResult();
        result.addWinningRank(Rank.FIRST);
        assertThrows(ArithmeticException.class, () -> {
            result.calculateEarningsRate(0);  // 입력 금액이 0인 경우
        });
    }
}
