package lotto;

import java.util.Map;

public class Profit {
    private final double rate;

    Profit(Map<Ranking, Integer> winningResult, int ticketQuantity) {
        long profit = calculateProfit(winningResult);
        this.rate = calculateRateOfProfit(profit, ticketQuantity);
    }

    private long calculateProfit(Map<Ranking, Integer> winningResult) {
        long profit = 0L;
        for (Ranking ranking : winningResult.keySet()) {
            profit += calculatePrizeByRanking(ranking, winningResult.get(ranking));
        }
        return profit;
    }

    private long calculatePrizeByRanking(Ranking ranking, int number) {
        return ranking.getPrize() * (long) number;
    }

    private double calculateRateOfProfit(long profit, int ticketQuantity) {
        double rate = (double) profit / (double) ticketQuantity;
        return Math.round(rate) / 10d;
    }

    public double getRate() {
        return rate;
    }
}
