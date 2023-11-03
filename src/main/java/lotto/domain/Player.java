package lotto.domain;

public class Player {
    private static LottoAmount lottoAmount;
    private static LottoCount lottoCount;
    private static Lotto[] lottos;

    public void setLottoAmount(LottoAmount lottoAmount) {
        this.lottoAmount = lottoAmount;
    }

    public void setLottoCount() {
        this.lottoCount = new LottoCount(lottoAmount.getLottoAmount());
    }
}
