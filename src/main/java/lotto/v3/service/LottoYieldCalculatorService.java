package lotto.v3.service;

import lotto.v3.model.LottoRank;
import java.util.Map;

import static lotto.v3.util.LottoConstants.LOTTO_PRICE;

public class LottoYieldCalculatorService {

    public double calculateYield(Map<LottoRank, Integer> matchCounts) {
        long totalReward = 0;
        int totalSpent = 0;

        for (Map.Entry<LottoRank, Integer> entry : matchCounts.entrySet()) {
            totalReward += entry.getKey().getPrizeMoney() * entry.getValue();
            totalSpent += entry.getValue() * LOTTO_PRICE.getValue();
        }

        double yield = 0.0;
        if (totalSpent > 0) {
            yield = (double) totalReward / totalSpent * 100.0;
        }

        return Math.round(yield * 100) / 100.0;
    }
}


