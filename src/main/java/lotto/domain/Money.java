package lotto.domain;

import static lotto.configuration.Constants.Config.*;
import static lotto.configuration.Constants.*;

public class Money {
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateMultiple(money);
        validateNegative(money);
    }

    private void validateMultiple(int money) {
        if (money % PRICE != 0) {
            throw new IllegalArgumentException(Errors.MESSAGE + PRICE + Errors.NEED_MULTIPLE_OF_PRICE);
        }
    }

    private void validateNegative(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException(Errors.MESSAGE + Errors.NOT_NEGATIVE_NUMBER);
        }
    }

    public int getMoney() {
        return money;
    }

    public int getLottoCount() {
        return money / PRICE;
    }
}
