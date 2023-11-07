package lotto;

import java.util.Map;

public class PrizeProfit {
    private final double rate;

    public PrizeProfit(PrizeStats prizeStats, long buyingPrice) {
        this.rate = calculateRate(calculatePrizeMoney(prizeStats), buyingPrice);
    }

    public double getRate() {
        return this.rate;
    }

    private long calculatePrizeMoney(PrizeStats prizeStats) {
        long sumOfPrizeMoney = 0;
        for (Map.Entry<PrizeGrade, Integer> entry : prizeStats.getGradeDist().entrySet()) {
            sumOfPrizeMoney += entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return sumOfPrizeMoney;
    }

    private double calculateRate(long prizeMoney, long buyingPrice) {
        return (double) prizeMoney / buyingPrice;
    }
}
