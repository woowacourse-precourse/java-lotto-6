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

    private double calculateRateOfProfit(long quantity, int ticketQuantity) {
        double rate = (double) quantity / (double) ticketQuantity;
        return Math.round(rate * 10) / 10;
    }

    public double getRate() {
        return rate;
    }
}
