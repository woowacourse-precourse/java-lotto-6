package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Ranking {
    NO_RANK(0, false, 0),
    FIFTH_RANKING(3, false, 2_000_000_000),
    FOURTH_RANKING(4, false, 30_000_000),
    THIRD_RANKING(5, false, 1_500_000),
    SECOND_RANKING(5, true, 50_000),
    FIRST_RANKING(6, false, 5_000);

    private final int accordedCount;
    private final boolean hasBonusNumber;
    private final int winningAmount;

    private Ranking(int accordedCount, boolean hasBonusNumber, int winningAmount) {
        this.accordedCount = accordedCount;
        this.hasBonusNumber = hasBonusNumber;
        this.winningAmount = winningAmount;
    }

    public static Ranking getRanking(int accordedCount, boolean hasBonusNumber) {
        return Arrays.stream(Ranking.values()).filter(ranking -> ranking.accordedCount == accordedCount)
                .filter(ranking -> ranking.hasBonusNumber == hasBonusNumber)
                .findAny().orElse(NO_RANK);
    }

    public static List<Ranking> getRankings() {
        return Arrays.stream(Ranking.values()).collect(Collectors.toList());
    }

    public int getAccordedCount() {
        return accordedCount;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
