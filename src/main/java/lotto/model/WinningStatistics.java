package lotto.model;

import java.util.Map;

public class WinningStatistics {

    private static final int INITIAL_COUNT = 0;
    private static final int SECOND_OR_THIRD_PLACE_STANDARD = 5;
    private static final int INCREMENT = 1;

    private final Map<Rank, Integer> winningStatistics;

    public WinningStatistics(Map<Rank, Integer> winningStatistics) {
        this.winningStatistics = winningStatistics;
        initialize();
    }

    private void initialize() {
        for (Rank rank : Rank.values()) {
            winningStatistics.put(rank, INITIAL_COUNT);
        }
    }

    public void checkWinningResult(int matchingCount, boolean isBonusNumberMatch) {
        for (Rank rank : Rank.values()) {
            if (matchingCount == rank.matchingCount) {
                checkSecondOrThirdPlace(rank, isBonusNumberMatch);
                checkRest(rank);
            }
        }
    }

    private void checkSecondOrThirdPlace(Rank rank, boolean isBonusNumberMatch) {
        if (isSecondOrThirdPlace(rank, isBonusNumberMatch)) {
            addWinningResult(rank);
        }
    }

    private boolean isSecondOrThirdPlace(Rank rank, boolean isBonusNumberMatch) {
        return (rank.matchingCount == SECOND_OR_THIRD_PLACE_STANDARD)
                && (isBonusNumberMatch == rank.isBonusNumberMatch);
    }

    private void checkRest(Rank rank) {
        if (rank.matchingCount != SECOND_OR_THIRD_PLACE_STANDARD) {
            addWinningResult(rank);
        }
    }

    private void addWinningResult(Rank rank) {
        winningStatistics.put(rank, winningStatistics.get(rank) + INCREMENT);
    }

    public int getTotalWinningAmount() {
        int totalWinningAmount = 0;
        for (Rank rank : Rank.values()) {
            totalWinningAmount += (rank.winningAmount) * (winningStatistics.get(rank));
        }
        return totalWinningAmount;
    }
}
