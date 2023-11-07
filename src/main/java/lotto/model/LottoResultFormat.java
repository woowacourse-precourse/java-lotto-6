package lotto.model;

public enum LottoResultFormat {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000),
    FAIL(0,0);

    private final int lottoOfMatching;
    private final int winningAmount;

    LottoResultFormat(int lottoOfMatching, int winningAmount) {
        this.lottoOfMatching = lottoOfMatching;
        this.winningAmount = winningAmount;
    }

    public int getLottoOfMatching() {
        return lottoOfMatching;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
