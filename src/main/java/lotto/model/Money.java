package lotto.model;

import static lotto.exception.ExceptionMessage.NEGATIVE_NUMBER_EXCEPTION;
import static lotto.exception.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;

public class Money {

    private static final int DEFAULT_VALUE = 0;

    private int money;

    private Money(final int money) {
        this.money = money;
    }

    public static Money createDefault() {
        return new Money(DEFAULT_VALUE);
    }

    public static Money from(final String moneyInput) {
        int money = convertToNumber(moneyInput);
        validateIsNotNegativeNumber(money);

        return new Money(money);
    }

    private static int convertToNumber(final String moneyInput) {
        try {
            return Integer.parseInt(moneyInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    private static void validateIsNotNegativeNumber(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION.getMessage());
        }
    }

    public void addMoney(final int value) {
        validateIsNotNegativeNumber(value);
        money += value;
    }

    public int getMoney() {
        return money;
    }
}
