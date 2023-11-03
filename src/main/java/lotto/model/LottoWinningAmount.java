package lotto.model;

public class LottoWinningAmount {
    private int lottoWinningAmount;

    private LottoWinningAmount(int lottoWinningAmount) {
        this.lottoWinningAmount = lottoWinningAmount;
    }

    public static LottoWinningAmount getInstance(int lottoWinningAmount) {
        return new LottoWinningAmount(lottoWinningAmount);
    }
}
