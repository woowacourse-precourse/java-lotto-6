package lotto.service;

import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.lotto.LottoRank;

public class LottoStatsService {

    private final int LOTTO_PRICE = 1000;

    public double calculateReturnRate(Map<LottoRank, Integer> lottoResult) {
        double returnRate = 0;
        int totalMoney = 0;
        int lottoAmount = 0;

        for (Entry<LottoRank, Integer> lotto : lottoResult.entrySet()) {
            int prize = lotto.getKey().getLottoRankPrize();
            int winner = lotto.getValue();
            lottoAmount += winner;
            totalMoney += prize * winner;
        }
        int purchaseMoney = lottoAmount * LOTTO_PRICE;

        if (totalMoney == 0) {
            return returnRate;
        }
        if (totalMoney != 0) {
            returnRate = (double) totalMoney / purchaseMoney;
        }
        return returnRate;
    }
}
