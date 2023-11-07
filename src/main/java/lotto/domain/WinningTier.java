package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningTier {

    private static final int WINNING_TIER_START_INDEX = 0;
    private static final int DEFAULT_VALUE = 0;
    private static final int PLUS_UNIT = 1;

    private HashMap<Integer, Integer> winningTier;

    public WinningTier() {
        this.winningTier = new HashMap<>();
    }

    public void estimate(List<Long> correctWinningsCount, List<Boolean> correctBonuses) {
        HashMap<Integer, Integer> tempWinningCounts = new HashMap<>();

        for (int i = WINNING_TIER_START_INDEX; i < correctWinningsCount.size(); i++) {
            Long correctWinningCount = correctWinningsCount.get(i);
            boolean correctBonus = correctBonuses.get(i);

            WinningStatistics winningConfirmResult = WinningStatistics.confirm(correctWinningCount, correctBonus);
            int rank = winningConfirmResult.getRank();
            tempWinningCounts.put(rank, tempWinningCounts.getOrDefault(rank, DEFAULT_VALUE) + PLUS_UNIT);
        }
        tempWinningCounts.forEach((rank, count) -> winningTier.merge(rank, count, Integer::sum));
    }

    public HashMap<Integer, Integer> toHashMap() {
        return this.winningTier;
    }
}
