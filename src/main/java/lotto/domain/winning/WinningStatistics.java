package lotto.domain.winning;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.amount.Amount;
import lotto.domain.rank.Rank;
import lotto.dto.WinningStatisticsDto;

public class WinningStatistics {

    private final Map<Rank, Long> rankCount;
    private final double profitRate;

    public WinningStatistics(final List<Rank> ranks, final Amount amount) {
        this.rankCount = calculateRankCounts(ranks);
        this.profitRate = calculateProfitRate(ranks, amount);
    }

    private Map<Rank, Long> calculateRankCounts(final List<Rank> ranks) {
        return ranks.stream()
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    private double calculateProfitRate(final List<Rank> ranks, final Amount amount) {
        long totalProfit = ranks.stream()
                .mapToLong(Rank::getProfit)
                .sum();
        return amount.getProfitMargin(totalProfit);
    }

    public WinningStatisticsDto convertToDto() {
        return new WinningStatisticsDto(this.rankCount, this.profitRate);
    }

    public Map<Rank, Long> getRankCount() {
        return this.rankCount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
