package lotto.domain;

import java.util.Map;

public class EarningsRate {
    public float getEarningsRate(int purchaseMoney, Map<LottoResult, Integer> resultCounts) {
        int totalPrizeAmount = 0;

        for (LottoResult result : LottoResult.values()) {
            Integer count = resultCounts.get(result);
            totalPrizeAmount += count * result.getPrize();
        }

        return ((float) totalPrizeAmount / purchaseMoney) * 100;
    }
}
