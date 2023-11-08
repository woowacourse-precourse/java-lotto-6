package lotto.domain;

public class LottoCount {
    private static final int LOTTO_PRICE = 1000;
    private final int lottoCount;

    private LottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static LottoCount from(PurchaseAmount purchaseAmount) {
        int lottoCount = (purchaseAmount.getPurchaseAmount()) / LOTTO_PRICE;
        return new LottoCount(lottoCount);
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
