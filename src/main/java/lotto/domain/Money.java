package lotto.domain;

public class Money {
    private final int money;

    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int inputValue) {
        validateZero(inputValue);
        validateDivideMoney(inputValue);
    }

    private void validateZero(int inputValue) {
        if (inputValue == ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivideMoney(int inputValue) {
        if (inputValue % THOUSAND != ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public int getTicket() {
        return money / 1000;
    }
}
