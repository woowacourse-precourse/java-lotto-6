package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0L);

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final long prize;

    LottoRank(int matchCount, boolean hasBonusNumber, long prize) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.prize = prize;
    }

    public static LottoRank of(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(values())
                .filter(lottoRank -> lottoRank.isMatch(matchCount, hasBonusNumber))
                .findFirst()
                .orElse(NONE);
    }

    private boolean isMatch(int matchCount, boolean hasBonusNumber) {
        return this.matchCount == matchCount && this.hasBonusNumber == hasBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

    public long getPrize() {
        return prize;
    }
}
