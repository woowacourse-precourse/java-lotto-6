package lotto.dto;

import java.util.Map;
import lotto.domain.rank.Rank;

public class WinningStatisticsDto {

    private final Map<Rank, Long> MatchedCounts;
    private final double profitRate;

    public WinningStatisticsDto(final Map<Rank, Long> MatchedCounts, final double profitRate) {
        this.MatchedCounts = MatchedCounts;
        this.profitRate = profitRate;
    }

    public Map<Rank, Long> getRankCounts() {
        return MatchedCounts;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
