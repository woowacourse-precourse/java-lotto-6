package lotto.domain;

import lotto.configuration.Constants;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public int getLottoCount() {
        return money / Constants.Rule.PRICE;
    }

    private void validate(int money) {
        if (money % Constants.Rule.PRICE != 0) {
            throw new IllegalArgumentException(Constants.Error.MESSAGE + Constants.Rule.PRICE + Constants.Error.NEED_MULTIPLE_OF_PRICE);
        }
    }
}
