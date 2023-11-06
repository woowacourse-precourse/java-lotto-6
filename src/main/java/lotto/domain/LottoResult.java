package lotto.domain;

public enum LottoResult {
    FIRST_PLACE(6, 2_000_000_000, false),
    SECOND_PLACE(5, 30_000_000, true),
    THIRD_PLACE(5, 1_500_000, false),
    FOURTH_PLACE(4, 50_000, false),
    FIFTH_PLACE(3, 5_000, false);

    private final int lottoMatchCount;
    private final int lottoWinningAmount;
    private final boolean isMatchBonusNumber;

    LottoResult(int lottoMatchCount, int lottoWinningAmount, boolean isMatchBonusNumber) {
        this.lottoMatchCount = lottoMatchCount;
        this.lottoWinningAmount = lottoWinningAmount;
        this.isMatchBonusNumber = isMatchBonusNumber;
    }

    public int getLottoMatchCount() {
        return lottoMatchCount;
    }

    public int getLottoWinningAmount() {
        return lottoWinningAmount;
    }

    public boolean getIsMatchBonusNumber() {
        return isMatchBonusNumber;
    }

}
