package lotto.dto.response;

import java.util.Map;

public class WinningResponse {
    private final Map<Integer, WinningStatistic> countGroupingByRank;
    private final double profitRate;

    public WinningResponse(final Map<Integer, WinningStatistic> statisticGroupingByRank, final double profitRate) {
        this.countGroupingByRank = statisticGroupingByRank;
        this.profitRate = profitRate;
    }

    public Map<Integer, WinningStatistic> getStatisticGroupingByRank() {
        return countGroupingByRank;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
