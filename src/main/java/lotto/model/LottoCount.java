package lotto.model;

import lotto.model.constant.LottoNumber;

public class LottoCount {
    private final int lottoCount;

    public LottoCount(Money money) {
        lottoCount = money.getMoney() / LottoNumber.DEFAULT_UNIT;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
