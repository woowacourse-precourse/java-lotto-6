package lotto.model;

public class LottoSellingPolicy {
    private static final int LOTTO_PRICE = 1000;

    public int calcuateLottoCount(final int purchasingMoney) {
        return purchasingMoney / LOTTO_PRICE;
    }
}
