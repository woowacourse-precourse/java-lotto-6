package lotto.domain;

import static lotto.domain.constant.LottoConstant.LOTTO_PRICE;

public class LottoCount {
    private final int count;

    public LottoCount(int count) {
        this.count = count;
    }

    public static LottoCount from(int purchase) {
        int count = purchase / LOTTO_PRICE;
        return new LottoCount(count);
    }

    public int getCount() {
        return count;
    }
}
