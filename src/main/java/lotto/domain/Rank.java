package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 5, false),
    FIFTH(5_000, 3, false),
    NONE(0, 0, false);

    private static final int SECOND_OR_THIRD_CASE = 5;

    private final int prize;
    private final int matchCount;
    private final boolean hasBonusBall;

    Rank(int prize, int matchCount, boolean hasBonusBall) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.hasBonusBall = hasBonusBall;
    }
    public static Rank calculate(int matchCount, boolean hasBonusBall) {
        if (matchCount == 5) {
            return checkBonusBall(hasBonusBall);
        }
        return Arrays.stream(Rank.values())
                .filter(value -> value.matchCount == matchCount)
                .findAny()
                .orElse(NONE);
    }

    private static Rank checkBonusBall(boolean hasBonusBall) {
        if (hasBonusBall) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isHasBonusBall() {
        return hasBonusBall;
    }

}
