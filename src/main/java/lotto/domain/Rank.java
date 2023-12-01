package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, BonusMatchStatus.NO_MATTER),
    SECOND(5, 30_000_000, BonusMatchStatus.NEED),
    THIRD(5, 1_500_000, BonusMatchStatus.NOT_NEED),
    FORTH(4, 50_000, BonusMatchStatus.NO_MATTER),
    FIFTH(3, 5_000, BonusMatchStatus.NO_MATTER),
    NONE(-1, 0, BonusMatchStatus.NO_MATTER);

    private final int countOfMatch;
    private final int prize;
    private final BonusMatchStatus bonusMatchStatus;


    Rank(int countOfMatch, int prize, BonusMatchStatus bonusMatchStatus) {
        this.countOfMatch = countOfMatch;
        this.prize = prize;
        this.bonusMatchStatus = bonusMatchStatus;
    }

    public static Rank from(int countOfMatch, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> isMatch(countOfMatch, bonusMatch, rank))
                .findFirst()
                .orElse(NONE);
    }

    private static boolean isMatch(int countOfMatch, boolean bonusMatch, Rank rank) {
        return rank.countOfMatch == countOfMatch && rank.bonusMatchStatus.matches(bonusMatch);
    }

    public int multiple(int count) {
        return prize * count;
    }
}
