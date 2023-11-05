package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000),
    NONE(0, false, 0),
    ;

    private int matchingCount;
    private boolean bonusNumberMatch;
    private int prize;

    LottoRank(int matchingCount, boolean bonusNumberMatch, int prize) {
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

    public int getPrize() {
        return prize;
    }

}
