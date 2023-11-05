package lotto.domain.lotto;

import lotto.global.constant.LottoRank;

import java.util.Map;

public class Profit {
    private static final int PERCENTAGE = 100;

    public double calculateProfit(int money, Map<LottoRank, Integer> winningResultMap) {
        double profit = 0;
        for (LottoRank lottoRank : winningResultMap.keySet()) {
            int rankCount = winningResultMap.getOrDefault(lottoRank, 0);
            profit += lottoRank.getPrice() * rankCount;
        }

        return Math.round((profit * PERCENTAGE) / money);
    }
}
