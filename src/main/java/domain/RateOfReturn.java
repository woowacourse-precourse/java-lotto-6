package domain;

import constant.Rank;
import java.util.HashMap;
import java.util.Map.Entry;

public class RateOfReturn {
    private final double rate;

    public RateOfReturn(HashMap<Rank, Integer> rankCountsMap, long money) {
        long totalIncome = getTotalIncome(rankCountsMap);
        this.rate = calculateRateOfReturn(totalIncome, money);
    }

    public double getRate() {
        return rate;
    }

    private static long getTotalIncome(HashMap<Rank, Integer> rankCountsMap) {
        long totalIncome = 0;
        for (Entry<Rank, Integer> entry : rankCountsMap.entrySet()) {
            if (entry.getValue() != 0) {
                Rank rank = entry.getKey();
                totalIncome += (long) rank.getPrize() * entry.getValue();
            }
        }
        return totalIncome;
    }

    private static double calculateRateOfReturn(long totalIncome, long money) {
        double rateOfReturn = (double) totalIncome / money * 100;
        rateOfReturn = Math.round(rateOfReturn * 10) / 10.0;
        return rateOfReturn;
    }
}
