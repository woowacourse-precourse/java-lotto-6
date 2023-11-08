package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOTHING(0, 0);

    private final int countOfMatch;
    private final long lotteryWinnings;

    Rank(int countOfMatch, long lotteryWinnings) {
        this.countOfMatch = countOfMatch;
        this.lotteryWinnings = lotteryWinnings;
    }

    public static Rank valueOf(int countOfMatch, boolean containsBonus) {

        if (isSecond(countOfMatch, containsBonus)) {
            return SECOND;
        }

        return checkRank(countOfMatch);
    }

    private static boolean isSecond(int countOfMatch, boolean containsBonus) {
        return countOfMatch == 5 && containsBonus;
    }

    private static Rank checkRank(int countOfMatch) {
        return Arrays.stream(Rank.values()).filter(rank -> isSame(countOfMatch, rank)).findFirst().orElse(NOTHING);
    }

    private static boolean isSame(int countOfMatch, Rank rank) {
        return rank != SECOND && rank.countOfMatch == countOfMatch;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public long getLotteryWinnings() {
        return lotteryWinnings;
    }
}
