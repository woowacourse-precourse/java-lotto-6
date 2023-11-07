package lotto.service;

import lotto.view.Rank;
import lotto.view.RankResult;

public class Statics {

    private double rate;
    public Statics(int money, RankResult rankResult) {
        this.rate = (getTotalMoney(rankResult) / money)*100;
    }
    private long getTotalMoney(RankResult rankResult) {
        int result = 0;
        for (Rank rank : Rank.values()) {
            result += rankResult.getCount(rank) * rank.getMoney();
        }
        return result;
    }

    public double getRate() {
        return rate;
    }
}
