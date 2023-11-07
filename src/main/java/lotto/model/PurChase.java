package lotto.model;

public class PurChase {
    private final int lottoCount;

    public PurChase(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public static PurChase inputPurchase(int inputPurchase) {
        return new PurChase(inputPurchase);
    }
}
