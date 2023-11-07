package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class ResultStatics {
    private final static int PERCENTAGE = 100;
    private final Map<LottoPrize, Integer> prizeResult;
    private final int phrasedMoney;
    private final double earningRate;
    private final long totalEarning;

    public ResultStatics(Map<LottoPrize, Integer> prizeResult, int phrasedMoney) {
        this.prizeResult = Collections.unmodifiableMap(prizeResult);
        this.phrasedMoney = phrasedMoney;
        this.totalEarning = calculateTotalEarning();
        this.earningRate = calculateEarningRate();
    }

    private double calculateEarningRate() {
        return ((double) totalEarning / phrasedMoney) * PERCENTAGE;
    }

    public long calculateTotalEarning() {
        long totalEarning = 0;
        for (LottoPrize prizeStatus : prizeResult.keySet()) {
            int prizeCount = prizeResult.get(prizeStatus).intValue();
            totalEarning += prizeStatus.getPrizeMoney() * prizeCount;
        }
        return totalEarning;
    }

    public Map<LottoPrize, Integer> getPrizeResult() {
        return prizeResult;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public int getPhrasedMoney() {
        return phrasedMoney;
    }

    public long getTotalEarning() {
        return totalEarning;
    }
}
