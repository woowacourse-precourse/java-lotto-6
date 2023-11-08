package mytest;

import lotto.service.PrizeCalculator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrizeCalculatorTest {
    @Test
    void testCalcualte() {
        Map<String, Integer> lottoMatchingResult = new HashMap<>();
        lottoMatchingResult.put("1등", 1);
        lottoMatchingResult.put("2등", 3);
        lottoMatchingResult.put("3등", 6);

        int totalPrize = PrizeCalculator.calculate(lottoMatchingResult);
        int expectedTotalPrize = 2_000_000_000 + (30_000_000 * 3) + (1_500_000 * 6);

        assertEquals(expectedTotalPrize, totalPrize);
    }

    @Test
    void testCalculateProfitRate() {
        int totalPrize = 5_000;
        int inputPrice = 8_000;

        float profitRate = PrizeCalculator.calculateProfitRate(totalPrize, inputPrice);

        float expectedProfitRate = 62.5f;

        // Assert statements
        assertEquals(expectedProfitRate, profitRate, 0.01f);
    }


}
