package lotto.v3.service;

import lotto.v3.model.LottoRank;
import java.util.Map;

import static lotto.v3.util.LottoConstants.LOTTO_PRICE;

public class LottoYieldCalculatorService {

    public double calculateYield(Map<LottoRank, Integer> matchCounts, int purchasedNumbersSize) {
        long totalReward = 0;

        for (Map.Entry<LottoRank, Integer> entry : matchCounts.entrySet()) {
            totalReward += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return ((double) totalReward / (purchasedNumbersSize * LOTTO_PRICE.getValue())) * 100;
    }
}


