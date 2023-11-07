package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import lotto.utils.Constants;

public class LottoResult {

    private static final int SCALE = 2;
    private final Map<MatchCount, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();
        for (MatchCount matchCount : MatchCount.values()) {
            result.put(matchCount, Constants.ZERO);
        }
    }


    public void addResult(final MatchCount matchCount) {
        result.put(matchCount, result.get(matchCount) + 1);
    }

    public int getMatchedTicketCount(final MatchCount matchCount) {
        return result.get(matchCount);
    }

    public double calculateRoundedEarningsRate(final int purchaseAmount) {
        long totalEarnings = calculateTotalEarnings();
        double earningsRate = calculateEarningsRate(totalEarnings, purchaseAmount);
        return roundEarningsRate(earningsRate);
    }

    private long calculateTotalEarnings() {
        return result.entrySet().stream()
            .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
            .sum();
    }

    private double calculateEarningsRate(final long totalEarnings, int purchaseAmount){
        long totalInvestment = (long) purchaseAmount * Constants.LOTTO_PRICE;
        return (double) totalEarnings / totalInvestment * Constants.HUNDRED;
    }

    private double roundEarningsRate(final double earningsRate) {
        BigDecimal bd = new BigDecimal(Double.toString(earningsRate))
            .setScale(SCALE, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
