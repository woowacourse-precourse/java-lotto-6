package lotto.Domain;

import static lotto.validator.ErrorMessage.ErrorMessage.NOT_DIVIDED_THOUSAND_EXCEPTION_MESSAGE;
public class Money {
    private static final int THOUSAND = 1000;

    private int money;

    public Money(int money) {
        this.money = money;
    }

    public static Money create(int money) {
        validateMoneyIsDividedInThousand(money);
        return new Money(money);
    }

    private static void validateMoneyIsDividedInThousand(int money) {
        if (money % THOUSAND != 0) {
            throw new IllegalArgumentException(NOT_DIVIDED_THOUSAND_EXCEPTION_MESSAGE);
        }
    }

    public int amountOfLotto() {
        return money / THOUSAND;
    }

    public int getMoney() {
        return money;
    }
}
