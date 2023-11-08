package lotto.domain;

public class Money {
    private static final int ZERO = 0;
    private static final int THOUSAND = 1000;
    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int input) {
        validateRemainder(input);
    }

    private void validateRemainder(int input) {
        if (input % THOUSAND != ZERO) {
            throw new IllegalArgumentException();
        }
    }

    public int getTicket() {
        return money / THOUSAND;
    }
}