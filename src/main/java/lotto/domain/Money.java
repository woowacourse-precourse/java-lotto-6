package lotto.domain;

import lotto.constant.ExceptionMessage;
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
            throw new IllegalArgumentException(ExceptionMessage.NOT_POSITIVE_MESSAGE);
        }
    }

    private void validateUnit(int money) {
        if (money % LottoConfig.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_UNIT_NUMBER_MESSAGE);
        }
    }

    public int count() {
        return money / LottoConfig.LOTTO_PRICE;
    }

    public int getPrice() {
        return money;
    }

}
