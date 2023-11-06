package lotto.model.lottoResultChecker;
import java.util.Map;
public class LottoReturnsCalculator {
    private final int ticketCost;
    private final Map<LottoRank, Integer> rankResults;

    public LottoReturnsCalculator(int ticketCost, Map<LottoRank, Integer> rankResults) {
        this.ticketCost = ticketCost;
        this.rankResults = rankResults;
    }

    public double calculateReturnRate() {
        long totalEarnings = calculateTotalEarnings();
        long totalCost = calculateTotalCost();
        return ((double) totalEarnings / totalCost) * 100;
    }

    private long calculateTotalEarnings() {
        return rankResults.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    private long calculateTotalCost() {
        return (long) ticketCost * rankResults.values().stream().mapToInt(Integer::intValue).sum();
    }
}