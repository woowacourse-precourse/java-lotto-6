package lotto.model;

public class LottoWinningReward {
    private int lottoWinningAmount;

    private LottoWinningReward(int lottoWinningAmount) {
        this.lottoWinningAmount = lottoWinningAmount;
    }

    public static LottoWinningReward getInstance(int lottoWinningAmount) {
        return new LottoWinningReward(lottoWinningAmount);
    }

    public void addWinningReward(int reward) {
        lottoWinningAmount += reward;
    }

    public int getLottoWinningAmount() {
        return lottoWinningAmount;
    }
}
