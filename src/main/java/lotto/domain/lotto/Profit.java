package lotto.domain.lotto;

import lotto.global.constant.LottoRank;

import java.util.Map;

public class Profit {
    private static final double HUNDRED = 100.0;

    public double calculateProfit(long money, Map<LottoRank, Integer> winningResultMap) {
        double profit = 0;
        for (LottoRank lottoRank : winningResultMap.keySet()) {
            int rankCount = winningResultMap.getOrDefault(lottoRank, 0);
            profit += lottoRank.getPrice() * rankCount;
        }

        double profitRate = (profit / (double) money) * 100;

        return Math.round(profitRate * HUNDRED) / HUNDRED;
    }
}
