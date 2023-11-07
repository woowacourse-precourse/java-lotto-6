package lotto.domain;

public enum WiningRank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private int matchCount;
    private boolean bonusMatch;
    private int winingAmount;

    WiningRank(int matchCount, boolean bonusMatch, int winingAmount) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.winingAmount = winingAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getWiningAmount() {
        return winingAmount;
    }
}
