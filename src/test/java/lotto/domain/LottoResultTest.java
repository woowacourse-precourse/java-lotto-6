package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoResultTest {
    @Test
    void calculateReturnRateTest() {
        Map<Prize, Integer> prizeCounts = new EnumMap<>(Prize.class);
        prizeCounts.put(Prize.FIRST, 1); // Assuming 1 first prize
        prizeCounts.put(Prize.SECOND, 0); // Assuming 0 second prizes
        prizeCounts.put(Prize.THIRD, 0); // and so on...
        prizeCounts.put(Prize.FOURTH, 0);
        prizeCounts.put(Prize.FIFTH, 0);
        int purchaseAmount = 5000; // Assuming the purchase amount is 5000

        LottoResult lottoResult = new LottoResult(prizeCounts, purchaseAmount);
        double expectedReturnRate = 40000000.0; // This is the expected return rate (2 billion / 5000 * 100)
        double actualReturnRate = lottoResult.getReturnRate();

        assertEquals(expectedReturnRate, actualReturnRate);
    }
}