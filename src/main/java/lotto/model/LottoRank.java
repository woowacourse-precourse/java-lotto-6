package lotto.model;

public enum LottoRank {

    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000);

    private final int matchCount;
    private final boolean matchBonusNumber;
    private final int winningMoney;

    LottoRank(int matchCount, boolean matchBonusNumber, int winningMoney) {
        this.matchCount = matchCount;
        this.matchBonusNumber = matchBonusNumber;
        this.winningMoney = winningMoney;
    }
}
