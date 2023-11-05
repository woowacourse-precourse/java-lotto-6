package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIFTH(3, false, 5_000L),
    FOURTH(4, false, 50_000L),
    THIRD(5, false, 1_500_000L),
    SECOND(5, true, 30_000_000L),
    FIRST(6, false, 2_000_000_000L),
    NONE(0, false, 0L),
    ;

    private int matchingCount;
    private boolean bonusNumberMatch;
    private long prize;

    LottoRank(int matchingCount, boolean bonusNumberMatch, long prize) {
        this.matchingCount = matchingCount;
        this.bonusNumberMatch = bonusNumberMatch;
        this.prize = prize;
    }

    public static LottoRank of(int matchingCount, boolean bonusNumberMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == matchingCount)
                .filter(rank -> !rank.bonusNumberMatch || bonusNumberMatch)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean getBonusNumberMatch() {
        return bonusNumberMatch;
    }

    public long getPrize() {
        return prize;
    }

}
