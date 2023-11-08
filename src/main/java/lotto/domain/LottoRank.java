package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchCount;
    private final boolean isBonusMatch;
    private final int prize;

    LottoRank (int matchCount, boolean isBonusMatch, int prize) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank of(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.matchCount == matchCount &&
                        (isBonusMatch == rank.isBonusMatch))
                .findFirst()
                .orElse(NONE);
    }
}
