package lotto.model;

public enum LottoResultFormat {
    THREE(3, "5,000"),
    FOUR(4, "50,000"),
    FIVE(5, "1,500,000"),
    FIVE_BONUS(5, "30,000,000"),
    SIX(6, "2,000,000,000"),
    FAIL(0,"0");

    private final int lottoOfMatching;
    private final String winningAmount;

    LottoResultFormat(int lottoOfMatching, String winningAmount) {
        this.lottoOfMatching = lottoOfMatching;
        this.winningAmount = winningAmount;
    }

    public int getLottoOfMatching() {
        return lottoOfMatching;
    }

    public String getWinningAmount() {
        return winningAmount;
    }
}
