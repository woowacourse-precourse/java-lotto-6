package lotto.model;

public enum LottoRank {
    RANK1(6, false),
    RANK2(5, true),
    RANK3(5, false),
    RANK4(4, false),
    RANK5(3, false),
    NONE(0, false);

    private final int matchCount;
    private final boolean hasBonusNumber;

    LottoRank(int matchCount, boolean hasBonusNumber) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public boolean isMatch(int matchCount, int bonusMatchCount) {
        return this.matchCount == matchCount && this.hasBonusNumber == (bonusMatchCount > 0);
    }
}
