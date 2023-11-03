package lotto.model;

public class Money {

    private int money;

    private Money(final int money) {
        this.money = money;
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
            throw new IllegalArgumentException();
        }
    }

    private static void validateIsNotNegativeNumber(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException();
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
