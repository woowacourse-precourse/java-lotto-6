package lotto.domain;

import static lotto.configuration.InputFormatConfig.LOTTO_PRICE;

public class LottoCount {
    private final int lottoCount;

    private LottoCount(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static LottoCount from(int purchaseAmount) {
        return new LottoCount(purchaseAmount / LOTTO_PRICE);
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
