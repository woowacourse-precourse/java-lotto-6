package lotto.service;

import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.lotto.LottoRank;

public class LottoStatsService {

    private final int LOTTO_PRICE = 1000;

    public double calculateReturnRate(Map<LottoRank, Integer> lottoResult) {
        double returnRate = 0.0;
        double totalMoney = 0.0;
        double lottoAmount = 0.0;

        for (Entry<LottoRank, Integer> lotto : lottoResult.entrySet()) {
            int prize = lotto.getKey().getLottoRankPrize();
            int winner = lotto.getValue();
            lottoAmount += winner;
            totalMoney += prize * winner;
        }
        if (totalMoney != 0) {
            double purchaseMoney = lottoAmount * LOTTO_PRICE;
            returnRate = (double) totalMoney / purchaseMoney * 100;
            returnRate = (double) Math.round(returnRate * 10) / 10;
        }
        return returnRate;
    }
}
