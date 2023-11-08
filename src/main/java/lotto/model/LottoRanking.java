package lotto.model;

import java.util.Arrays;

public enum LottoRanking {
    NONE_MATCH(0, 0, false),
    FIFTH(3, 5_000, false),
    FOURTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchCount;
    private final int prize;
    private final boolean hasBonusNumber;

    LottoRanking(int matchCount, int prize, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }

    public static LottoRanking determineRanking(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(LottoRanking.values())
                .filter(ranking -> ranking.matchCount == matchCount && ranking.hasBonusNumber == hasBonusNumber)
                .findAny()
                .orElse(NONE_MATCH);
    }
}
