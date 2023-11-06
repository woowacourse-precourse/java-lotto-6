package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningTier {

    private static final int DEFAULT_VALUE = 0;
    private static final int PLUS_UNIT = 1;

    private static HashMap<Integer, Integer> winningTier = new HashMap<>();

    public static void estimate(List<Long> correctWinningsCount, List<Boolean> correctBonuses) {
        HashMap<Integer, Integer> tempWinningTier = new HashMap<>();

        for (int i = 0; i < correctWinningsCount.size(); i++) {
            Long correctWinningCount = correctWinningsCount.get(i);
            boolean correctBonus = correctBonuses.get(i);

            WinningStatistics winningConfirmResult = WinningStatistics.confirm(correctWinningCount, correctBonus);

            int rank = winningConfirmResult.getRank();
            tempWinningTier.put(rank, tempWinningTier.getOrDefault(rank, DEFAULT_VALUE) + PLUS_UNIT);
        }
        tempWinningTier.forEach(
                (rank, count) -> winningTier.merge(rank, count, Integer::sum));
    }

    public static HashMap<Integer, Integer> getWinningTier() {
        return winningTier;
    }
}
