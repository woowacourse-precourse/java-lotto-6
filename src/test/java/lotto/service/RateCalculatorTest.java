package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;

public class RateCalculatorTest {
    @DisplayName("당첨금을 계산한다.")
    @Test
    public void testCalculateWinnings() {
        List<Integer> resultList = Arrays.asList(1, 2, 3, 4, 5);
        int winnings = RateCalculator.calculateWinnings(resultList);

        assertEquals(5000 * 1 + 50000 * 2 + 1500000 * 3 + 30000000 * 4 + 2000000000 * 5, winnings);
    }

    @DisplayName("수익률은 소수점 둘째 자리에서 반올림한다.")
    @Test
    public void testCalculateRate() {
        int purchaseAmount = 100000;
        List<Integer> resultList = Arrays.asList(1, 2, 3, 4, 5);
        double expectedRate = ((double) RateCalculator.calculateWinnings(resultList) / purchaseAmount) * 100;
        double actualRate = RateCalculator.calculateRate(purchaseAmount, resultList);

        assertEquals(expectedRate, actualRate, 0.1);
    }
}



