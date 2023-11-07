package lotto.domain;

public class Money {
    private static final int MIN_MONEY = 0;
    private static final int CURRENCY = 1000;

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money) {
        validateOufOfRange(money);
        validateMultipleOf1000(money);
    }

    private void validateMultipleOf1000(int money) {
        if (isMultipleOf1000(money)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isMultipleOf1000(int money) {
        return (money % CURRENCY) == 0;
    }

    private void validateOufOfRange(int money) {
        if (isOutOfRange(money)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isOutOfRange(int money) {
        return money <= MIN_MONEY;
    }

    public int getLottoCount() {
        return money / CURRENCY;
    }
}
