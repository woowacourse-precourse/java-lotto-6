package lotto.dto;

import lotto.domain.LottoWinningTier;
import java.util.Map;

public class LottoStatisticsResult {
    private final Map<LottoWinningTier, Integer> WinningCounts;
    private final double percentOfTotalWinningAmount;

    public LottoStatisticsResult(Map<LottoWinningTier, Integer> winningCounts, double percentOfTotalWinningAmount) {
        WinningCounts = winningCounts;
        this.percentOfTotalWinningAmount = percentOfTotalWinningAmount;
    }

    public double getPercentOfTotalWinningAmount() {
        return percentOfTotalWinningAmount;
    }

    public Map<LottoWinningTier, Integer> getWinningCounts() {
        return WinningCounts;
    }
}
