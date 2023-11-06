package lotto.domain;

import static lotto.domain.LottoValue.LOTTO_PRICE;

public class LottoStore {

    public int getLottoQuantity(int money) {
        return sellLotto(money);
    }

    private int sellLotto(int money) {
        return money / LOTTO_PRICE;
    }
}
