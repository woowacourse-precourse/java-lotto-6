package lotto.model;

public enum LottoRank {
    FIFTH(5000),
    FOURTH(50000),
    THIRD(1500000),
    SECOND(30000000),
    FIRST(2000000000),
    NO(0);

    private final int winnings;

    LottoRank(int winnings) {
        this.winnings = winnings;
    }

    public boolean isWin() {
        return this != LottoRank.NO;
    }

    public int myWinnings() {
        return winnings;
    }

    public int lottoRankMapper(LottoRank lottoRank) {
        return winnings;
    }

}
