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
        return ((double) totalEarnings - totalCost) / totalCost * 100;
    }

    private long calculateTotalEarnings(Map<LottoRank, Integer> rankResults) {
        return rankResults.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    private long calculateTotalCost(Map<LottoRank, Integer> rankResults) {
        return (long) ticketCost * rankResults.values().stream().mapToInt(Integer::intValue).sum();
    }
}