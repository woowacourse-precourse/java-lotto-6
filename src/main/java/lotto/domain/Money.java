package lotto.domain;

import lotto.constant.LottoConfig;

public class Money {

    private final int money;

    public Money(int money) {
        validatePositive(money);
        validateUnit(money);
        this.money = money;
    }

    private void validatePositive(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(int money) {
        if (money % LottoConfig.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int count() {
        return money / LottoConfig.LOTTO_PRICE;
    }

}
