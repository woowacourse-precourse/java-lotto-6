package domain;

import static constant.ConstantNumber.LOTTO_PRICE;

public class LottoCount {
    private final long lottoCount;

    public LottoCount(long money) {
        this.lottoCount = money / LOTTO_PRICE.getNumber();
    }

    public long getLottoCount() {
        return lottoCount;
    }
}
