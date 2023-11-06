package lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    LOSE(0, 0, false);

    private static final int SPECIAL_CASE = 5;

    private final int prize;
    private final int matchCount;
    private final boolean hasBonusBall;

    LottoRank(int prize, int matchCount, boolean hasBonusBall) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.hasBonusBall = hasBonusBall;
    }

    public static LottoRank calculate(int matchCount, boolean hasBonusBall) {
        if (matchCount == SPECIAL_CASE) {
            return checkBonusBall(hasBonusBall);
        }
        return Arrays.stream(LottoRank.values())
                .filter(value -> value.matchCount == matchCount)
                .findAny()
                .orElse(LOSE);
    }

    private static LottoRank checkBonusBall(boolean hasBonusBall) {
        if (hasBonusBall) {
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
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