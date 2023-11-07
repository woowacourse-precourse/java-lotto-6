package lotto.domain;

import static lotto.configuration.InputFormatConfig.LOTTO_PRICE;

public class LottoCount {
    private final int lottoCount;

    private LottoCount(final int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static LottoCount from(final int purchaseAmount) {
        return new LottoCount(purchaseAmount / LOTTO_PRICE);
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
