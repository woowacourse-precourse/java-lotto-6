package lotto.model;

public enum LottoRank {
    RANK1(6, false, "6개 일치 (2,000,000,000원)", 2000000000),
    RANK2(5, true, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    RANK3(5, false, "5개 일치 (1,500,000원)", 1500000),
    RANK4(4, false, "4개 일치 (50,000원)", 50000),
    RANK5(3, false, "3개 일치 (5,000원)", 5000),
    NONE(0, false, "", 0);

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final String status;
    private final int prize;

    LottoRank(int matchCount, boolean hasBonusNumber, String status, int prize) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.status = status;
        this.prize = prize;
    }

    public boolean isMatch(int matchCount, int bonusMatchCount) {
        return this.matchCount == matchCount && this.hasBonusNumber == (bonusMatchCount > 0);
    }

    public String printStatus() {
        return this.status;
    }

    public int getPrize() {
        return this.prize;
    }
}
