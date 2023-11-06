package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class WinningTier {

    private static final int FIRST_WINNING_TIER_NUMBER_KEY = 1;
    private static final int SECOND_WINNING_TIER_KEY = 2;
    private static final int THIRD_WINNING_TIER_KEY = 3;
    private static final int FOUR_WINNING_TIER_KEY = 4;
    private static final int FIFTH_WINNING_TIER_KEY = 5;

    private static final int DEFAULT_VALUE = 0;
    private static final int PLUS_UNIT = 1;

    private static HashMap<Integer, Integer> winningTier = new HashMap<>();

    public static void estimate(List<Long> correctWinningsCount, List<Boolean> correctBonuses) {
        for (int i = 0; i < correctWinningsCount.size(); i++) {
            Long correctWinningCount = correctWinningsCount.get(i);
            boolean correctBonus = correctBonuses.get(i);

            WinningStatistics winningConfirmResult = WinningStatistics.confirm(correctWinningCount, correctBonus);

            if (WinningStatistics.FIRST.name() == winningConfirmResult.name()) {
                winningTier.put(FIRST_WINNING_TIER_NUMBER_KEY, winningTier.getOrDefault(FIRST_WINNING_TIER_NUMBER_KEY, DEFAULT_VALUE) + PLUS_UNIT);
            }

            if (WinningStatistics.SECOND.name() == winningConfirmResult.name()) {
                winningTier.put(SECOND_WINNING_TIER_KEY, winningTier.getOrDefault(SECOND_WINNING_TIER_KEY, DEFAULT_VALUE) + PLUS_UNIT);
            }

            if (WinningStatistics.THIRD.name() == winningConfirmResult.name()) {
                winningTier.put(THIRD_WINNING_TIER_KEY, winningTier.getOrDefault(THIRD_WINNING_TIER_KEY, DEFAULT_VALUE) + PLUS_UNIT);
            }

            if (WinningStatistics.FOUR.name() == winningConfirmResult.name()) {
                winningTier.put(FOUR_WINNING_TIER_KEY, winningTier.getOrDefault(FOUR_WINNING_TIER_KEY, DEFAULT_VALUE) + PLUS_UNIT);
            }

            if (WinningStatistics.FIFTH.name() == winningConfirmResult.name()) {
                winningTier.put(FIFTH_WINNING_TIER_KEY, winningTier.getOrDefault(FIFTH_WINNING_TIER_KEY, DEFAULT_VALUE) + PLUS_UNIT);
            }
        }
    }

    public static HashMap<Integer, Integer> getWinningTier() {
        return winningTier;
    }
}
