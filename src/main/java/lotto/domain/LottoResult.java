package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class LottoResult {
    private final Map<Prize, Integer> prizeCounts;
    private final double returnRate;

    public LottoResult(Map<Prize, Integer> prizeCounts, int purchaseAmount) {
        this.prizeCounts = prizeCounts;
        this.returnRate = calculateReturnRate(prizeCounts, purchaseAmount);
    }

    public double calculateReturnRate(Map<Prize, Integer> prizeCounts, int purchaseAmount) {
        double totalPrize = prizeCounts.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getReward() * (double) entry.getValue())
                .sum();
        BigDecimal returnRate = BigDecimal.valueOf((totalPrize / purchaseAmount) * 100);
        return returnRate.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }


    public Map<Prize, Integer> getPrizeCounts() {
        return prizeCounts;
    }

    public double getReturnRate() {
        return returnRate;
    }
}
