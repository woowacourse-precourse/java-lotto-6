package lotto.domain;

import lotto.enums.Ranking;

import java.util.Map;

public class ResultMaker {
    private long totalPrize;
    private double prizeRate;
    private Map<Ranking, Integer> rankingCount;

    public ResultMaker(Map<Ranking, Integer> rankingCount, int money) {
        this.rankingCount = rankingCount;
        findTotalPrize();
        findPrizeRate(money);
    }

    private void findTotalPrize() {

    }

    private void findPrizeRate(int money) {

    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public double getPrizeRate() {
        return prizeRate;
    }
}
