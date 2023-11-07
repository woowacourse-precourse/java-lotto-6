package lotto.model;

import lotto.Lotto;

public enum LottoPrize {
    FIRST(1, 2000000000, 6, false),
    SECOND(2, 30000000, 5, true),
    THIRD(3, 1500000, 5, false),
    FOURTH(4, 50000, 4, false),
    FIFTH(5, 5000, 3, false),
    NONE(0, 0, 0, false);

    private final long prize;
    private final int rank;
    private final int matchCount;
    private final boolean bonusMatch;

    LottoPrize(int rank, long prize, int matchCount, boolean bonusMatch) {
        this.rank = rank;
        this.prize = prize;
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public long getPrize() {
        return this.prize;
    }

    public int getRank() {
        return this.rank;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean getBonusMatch() {
        return this.bonusMatch;
    }

    public static LottoPrize getPrizeRankByMatch(int matchCount, boolean bonusMatch) {
        for (LottoPrize prize : values()) {
            if (prize.getMatchCount() == matchCount && prize.getBonusMatch() == bonusMatch) {
                return prize;
            }
        }
        return LottoPrize.NONE;
    }
}
