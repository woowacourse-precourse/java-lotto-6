package lotto.dto.response;

import java.util.Map;

public class WinningResponse {
    private final Map<Integer, WinningStatistic> countGroupingByRank;
    private final double profitRate;

    public WinningResponse(final Map<Integer, WinningStatistic> countGroupingByRank, final double profitRate) {
        this.countGroupingByRank = countGroupingByRank;
        this.profitRate = profitRate;
    }

    public Map<Integer, WinningStatistic> getStatisticGroupingByRank() {
        return countGroupingByRank;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
