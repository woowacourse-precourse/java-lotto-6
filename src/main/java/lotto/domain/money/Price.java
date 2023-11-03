package lotto.domain.money;

public final class Price extends Money {
    public Price(final int amount) {
        super(amount);
    }

    public Money intoMoney() {
        return new Money(amount);
    }
}
