package lotto.domain;

public class Money {

    public static final Money ZERO = new Money(0L);

    private final Long amount;

    public Money(final Long amount) {
        validateNotNegative(amount);
        this.amount = amount;
    }

    private void validateNotNegative(final Long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
    }

    public Money add(final Money money) {
        return new Money(amount + money.amount);
    }

    public float getRate(final Money money) {
        return (float) amount / money.amount;
    }
}
