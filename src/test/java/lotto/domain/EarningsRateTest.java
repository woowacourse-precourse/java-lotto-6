package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EarningsRateTest {
    @Test
    void testGetEarningsRate() {
        EarningsRate earningsRateCalculator = new EarningsRate();
        int purchaseMoney = 50000;
        Map<LottoResult, Integer> resultCounts = new EnumMap<>(LottoResult.class);
        resultCounts.put(LottoResult.MATCH_3, 3);
        resultCounts.put(LottoResult.MATCH_4, 1);
        resultCounts.put(LottoResult.MATCH_5, 0);
        resultCounts.put(LottoResult.MATCH_5_WITH_BONUS, 0);
        resultCounts.put(LottoResult.MATCH_6, 0);

        int totalPrizeAmount = (3 * LottoResult.MATCH_3.getPrize()) + (LottoResult.MATCH_4.getPrize());

        float expectedEarningsRate = (float) totalPrizeAmount / purchaseMoney * 100;

        float actualEarningsRate = earningsRateCalculator.getEarningsRate(purchaseMoney, resultCounts);

        assertEquals(expectedEarningsRate, actualEarningsRate);
    }
}
