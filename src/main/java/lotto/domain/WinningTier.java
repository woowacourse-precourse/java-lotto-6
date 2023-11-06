package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class WinningTier {

    private static final int TWO_DOT_ROUND_VALUE = 100;
    private static final int WINNING_TIER_START_INDEX = 0;

    private HashMap<Integer, WinningStatistics> winningTier;

    public WinningTier() {
        this.winningTier = new HashMap<>();
    }

    public void estimate(List<Long> correctWinningsCount, List<Boolean> correctBonuses) {
        for (int i = WINNING_TIER_START_INDEX; i < correctWinningsCount.size(); i++) {
            Long correctWinningCount = correctWinningsCount.get(i);
            boolean correctBonus = correctBonuses.get(i);

            WinningStatistics winningConfirmResult = WinningStatistics.confirm(correctWinningCount, correctBonus);
            winningTier.put(i, winningConfirmResult);
        }
    }

    public HashMap<Integer, WinningStatistics> getWinningTier() {
        return this.winningTier;
    }

    public double calculateRounds(double price) {
        return (double) Math.round(price * TWO_DOT_ROUND_VALUE) / TWO_DOT_ROUND_VALUE;
    }

    public void calculateRateOfRevenue() {
        
    }
}
