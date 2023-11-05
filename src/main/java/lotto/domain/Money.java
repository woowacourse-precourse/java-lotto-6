package lotto.domain;

public class Money {
    private static final long TICKET_PRICE = 1000L;

    private final long money;

    public Money(long money) {
        validate(money);
        this.money = money;
    }

    private void validate(long money) {
        validateDivisible(money);
        validateMinimumBudget(money);
    }

    private void validateDivisible(long money) {
        if (money % TICKET_PRICE != 0L) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMinimumBudget(long money) {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    public long getMoney() {
        return money;
    }

    public long getTicket() {
        return money / TICKET_PRICE;
    }
}
