package lotto.domain.money;

public final class Wallet {
    private Money money;

    public Wallet(final Money money) {
        this.money = money;
    }

    public static Wallet empty() {
        return new Wallet(Money.zero());
    }

    public static Wallet with(final long amount) {
        return new Wallet(Money.from(amount));
    }

    public void spend(final Money other) {
        this.money = Money.clone(money.decreased(other));
    }

    public void fill(final Money other) {
        this.money = Money.clone(money.increased(other));
    }

    public boolean hasEqualOrMoreThan(final Money money) {
        return this.money.isEqualsOrGreaterThan(money);
    }
}
