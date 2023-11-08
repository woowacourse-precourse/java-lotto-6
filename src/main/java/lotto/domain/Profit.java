package lotto.domain;

import lotto.domain.enums.Rank;

public class Profit {
    private final double rate;

    public Profit(PlayerAmount playerAmount, RankResult rankResult) {
        this.rate = caculateProfitRate(playerAmount, rankResult);
    }

    private double caculateProfitRate(PlayerAmount playerAmount, RankResult rankResult) {
        return getTotalPrizeMoney(rankResult) * 0.1 / playerAmount.getLottoCount();
    }

    private int getTotalPrizeMoney(RankResult rankResult) {
        int totalMoney = 0;

        for (Rank rank : Rank.values()) {
            totalMoney += rankResult.getRankCount(rank) * rank.getPrizeMoney();
        }

        return totalMoney;
    }

    public double getRate() {
        return rate;
    }
}
