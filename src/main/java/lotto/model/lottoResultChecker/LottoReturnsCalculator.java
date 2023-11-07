package lotto.model.lottoResultChecker;
import java.util.Map;
public class LottoReturnsCalculator {
    private final int ticketCost;

    public LottoReturnsCalculator(int ticketCost) {
        this.ticketCost = ticketCost;
    }

    public double calculateReturnRate(Map<LottoRank, Integer> rankResults) {
        long totalEarnings = calculateTotalEarnings(rankResults);
        long totalCost = calculateTotalCost(rankResults);
        double returnRate = ((double) totalEarnings / totalCost) * 100;
        return Math.round(returnRate * 10.0) / 10.0;
    }

    private long calculateTotalEarnings(Map<LottoRank, Integer> rankResults) {
        return rankResults.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getWinningMoney() * entry.getValue())
                .sum();
    }

    private long calculateTotalCost(Map<LottoRank, Integer> rankResults) {
        return (long) ticketCost * rankResults.values().stream().mapToInt(Integer::intValue).sum();
    }
}