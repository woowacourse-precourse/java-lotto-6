package lotto.unitTest;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoProfit.getReturnRate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoProfitTest {

    @Test
    public void 수익률_계산_테스트() {
        // Given
        int purchasedLottosSize = 10;
        long totalReward = 20000;

        // When
        double returnRate = getReturnRate(purchasedLottosSize, totalReward);

        // Then
        assertEquals(200.0, returnRate, 0.001);
    }

    @Test
    public void 수익률_계산_테스트_2() {
        // Given
        int purchasedLottosSize = 8;
        long totalReward = 5000;

        // When
        double returnRate = getReturnRate(purchasedLottosSize, totalReward);

        // Then
        assertEquals(62.5, returnRate, 0.001);
    }
}
