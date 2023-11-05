package lotto.domain;

import lotto.enums.Ranking;

import java.util.Map;

public class ResultMaker {
    private long totalPrize;
    private double prizeRate;
    private Map<Ranking, Integer> rankingCounts;

    public ResultMaker(Map<Ranking, Integer> rankingCount, int money) {
        this.rankingCounts = rankingCount;
        findTotalPrize();
        findPrizeRate(money);
    }

    private void findTotalPrize() {
        for (Ranking ranking : rankingCounts.keySet()) {
            totalPrize += (long) ranking.getPrize() * rankingCounts.get(ranking);
        }
    }

    private void findPrizeRate(int money) {
        prizeRate = (long) (1000. * totalPrize / money + 0.5) / 10.;
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public double getPrizeRate() {
        return prizeRate;
    }
}
