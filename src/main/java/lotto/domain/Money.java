package lotto.domain;

import static lotto.utils.ErrorMessages.MONEY_NOT_MULTIPLE_UNIT;
import static lotto.utils.ErrorMessages.MONEY_UNDER_MINIMUM;


public class Money {
    public static final int LOTTO_PRICE = 1000;
    public static final int MINIMUM_AMOUNT = 1000;

    private final int money;

    public Money(int money) {
        validateMinimum(money);
        validateUnit(money);

        this.money = money;
    }

    private void validateUnit(int money) {
        if (!isMultipleOfPrice(money)) {
            throw new IllegalArgumentException(MONEY_NOT_MULTIPLE_UNIT);
        }
    }

    private boolean isMultipleOfPrice(int money) {
        return (money % LOTTO_PRICE) == 0;
    }

    private void validateMinimum(int money) {
        if (money < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(MONEY_UNDER_MINIMUM);
        }
    }

    public int getBuyLottoQuantity() {
        return money / LOTTO_PRICE;
    }

    public int getMoney() {
        return money;
    }
}
