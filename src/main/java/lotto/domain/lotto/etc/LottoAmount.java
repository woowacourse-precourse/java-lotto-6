package lotto.domain.lotto.etc;

public class LottoAmount {
    private static int lottoAmount;

    public LottoAmount(int amount) {
        this.lottoAmount = amount;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}
