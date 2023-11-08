package lotto.model.Money;

import static lotto.validator.ErrorMessage.ErrorMessage.NOT_DIVIDED_THOUSAND_EXCEPTION_MESSAGE;

public class Money {
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public static Money create(int money) {
        validateMoneyIsDividedInThousand(money);
        return new Money(money);
    }

    private static void validateMoneyIsDividedInThousand(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_THOUSAND_EXCEPTION_MESSAGE);
        }
    }

    public int amountOfLotto() {
        return money / 1000;
    }

    public int getMoney() {
        return money;
    }
}
