package lotto.model;

public enum LottoRank {
    RANK1(6, false, "6개 일치 (2,000,000,000원)"),
    RANK2(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    RANK3(5, false, "5개 일치 (1,500,000원)"),
    RANK4(4, false, "4개 일치 (50,000원)"),
    RANK5(3, false, "3개 일치 (5,000원)"),
    NONE(0, false, "");

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final String status;

    LottoRank(int matchCount, boolean hasBonusNumber, String status) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.status = status;
    }

    public boolean isMatch(int matchCount, int bonusMatchCount) {
        return this.matchCount == matchCount && this.hasBonusNumber == (bonusMatchCount > 0);
    }

public String printStatus() {
        return this.status;
}
}
