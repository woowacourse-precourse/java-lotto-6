package lotto.model;

public enum LottoResult {
    FIRST(2000000000, 6, false, "6개 일치 (2,000,000,000원)"),
    SECOND(30000000, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(1500000, 5, false, "5개 일치 (1,500,000원)"),
    FOURTH(50000, 4, false, "4개 일치 (50,000원)"),
    FIFTH(5000, 3, false, "3개 일치 (5,000원)"),
    NONE(0, 2, false, "미 당첨"),
    ;

    private final long prize;
    private final int matchCount;
    private final boolean isBonusMatch;
    private final String description;

    LottoResult(long prize, int matchCount, boolean isBonusMatch, String description) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.description = description;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }

    public String getDescription() {
        return description;
    }

    public static LottoResult of(int matchCount, boolean isBonusMatch) {
        if (matchCount == FIRST.matchCount) {
            return LottoResult.FIRST;
        }
        if (matchCount == SECOND.matchCount && isBonusMatch) {
            return LottoResult.SECOND;
        }
        if (matchCount == THIRD.matchCount) {
            return LottoResult.THIRD;
        }
        if (matchCount == FOURTH.matchCount) {
            return LottoResult.FOURTH;
        }
        if (matchCount == FIFTH.matchCount) {
            return LottoResult.FIFTH;
        }
        return NONE;
    }

    public boolean isWin() {
        return this != NONE;
    }
}
