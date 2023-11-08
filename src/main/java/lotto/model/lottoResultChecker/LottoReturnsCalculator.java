package lotto.model.lottoResultChecker;
import java.util.Map;
public class LottoReturnsCalculator {

    public LottoReturnsCalculator() {
    }

    public double calculateReturnRate(Map<LottoRank, Integer> rankResults, long totalCost) {
        long totalEarnings = calculateTotalEarnings(rankResults);
        if (totalCost == 0) {
            return 0.0;
        }

        double returnRate = ((double) totalEarnings / totalCost) * 100;
        return Math.round(returnRate * 10.0) / 10.0;
    }

    private long calculateTotalEarnings(Map<LottoRank, Integer> rankResults) {
        return rankResults.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }
}
