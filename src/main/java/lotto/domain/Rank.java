package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    BLANK(0, 0, false);

    private final int prize;
    private final int matchCount;
    private final boolean isMatchBonusNumber;

    Rank(int prize, int matchCount, boolean isMatchBonusNumber) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }

    public static Rank from(int matchCount, boolean isMatchBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.isMatchBonusNumber == isMatchBonusNumber)
                .findAny()
                .orElse(BLANK);
    }

    public int getPrize() {
        return prize;
    }
}
