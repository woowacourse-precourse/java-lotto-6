package lotto;

public enum LottoRank {

    FIRST_PLACE(2000000000, 6, false),
    SECOND_PLACE(30000000, 5, true),
    THIRD_PLACE(1500000, 5, false),
    FOURTH_PLACE(50000, 4, false),
    FIFTH_PLACE(5000, 3, false),
    NO_PLACE(0, 0, false);

    private final int prize;
    private final int matchCount;
    private final boolean isBonusMatch;

    LottoRank(int prize, int matchCount, boolean isBonusMatch) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
    }

    public static LottoRank valueOf(int matchCount, boolean isBonusMatch) {
        if (matchCount == 6) {
            return FIRST_PLACE;
        }
        if (matchCount == 5 && isBonusMatch) {
            return SECOND_PLACE;
        }
        if (matchCount == 5) {
            return THIRD_PLACE;
        }
        if (matchCount == 4) {
            return FOURTH_PLACE;
        }
        if (matchCount == 3) {
            return FIFTH_PLACE;
        }
        return NO_PLACE;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }
}
