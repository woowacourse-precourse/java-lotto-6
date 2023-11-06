package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class WinningTier {

    private static final int DEFAULT_VALUE = 0;
    private static final int PLUS_UNIT = 1;

    private static HashMap<Integer, Integer> winningTier = new HashMap<>();

    public static void estimate(List<Long> correctWinningsCount, List<Boolean> correctBonuses) {
        for (int i = 0; i < correctWinningsCount.size(); i++) {
            Long correctWinningCount = correctWinningsCount.get(i);
            boolean correctBonus = correctBonuses.get(i);

            WinningStatistics winningConfirmResult = WinningStatistics.confirm(correctWinningCount, correctBonus);

            int rank = winningConfirmResult.getRank();
            winningTier.put(rank, winningTier.getOrDefault(rank, DEFAULT_VALUE) + PLUS_UNIT);
        }
    }

    public static HashMap<Integer, Integer> getWinningTier() {
        return winningTier;
    }
}
