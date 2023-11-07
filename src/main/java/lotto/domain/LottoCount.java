package lotto.domain;

import static lotto.domain.constant.LottoConstant.LOTTO_PRICE;

public class LottoCount {
    private final int count;

    private LottoCount(int count) {
        this.count = count;
    }

    public static LottoCount from(int purchase) {
        int count = calculateCount(purchase);
        return new LottoCount(count);
    }

    private static int calculateCount(int purchase) {
        return purchase / LOTTO_PRICE;
    }

    public int getCount() {
        return count;
    }
}
