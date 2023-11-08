package lotto.dto.response;

import java.util.Map;

public class LottoWinningStatsResponse {
    private final Map<Integer, WinningStatsResponse> winningStats;
    private final double totalProfit;

    public LottoWinningStatsResponse(Map<Integer, WinningStatsResponse> winningStats, double totalProfit) {
      this.winningStats = winningStats;
      this.totalProfit = totalProfit;
    }

    public double getTotalProfit() {
        return totalProfit;
    }

    public Map<Integer, WinningStatsResponse> getWinningStats() {
        return winningStats;
    }
}
