package lotto.dto;

import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class RateOfReturnResponse {
    private final Lottos lottos;
    private final Map<Rank, Integer> rankCount;

    private final double profitPercentage;

    public RateOfReturnResponse(Lottos lottos, Map<Rank, Integer> rankCount) {
        this.lottos = lottos;
        this.rankCount = rankCount;
        this.profitPercentage = calculateProfitPercentage();
    }


    public double calculateProfitPercentage() {
        int purchaseAmount = lottos.getSize() * 1000;
        int profit = 0;
        for (Rank rank : rankCount.keySet()) {
            int rankingCount = rankCount.get(rank);
            int prizeMoney = rank.getReward();
            profit += (rankingCount * prizeMoney);
        }
        return (double) profit / purchaseAmount;
    }

    @Override
    public String toString() {
        return "총 수익률은 " + this.profitPercentage + "%입니다.";
    }


}
