package lotto.domain.money;

public final class Wallet {
    private Money money;

    public Wallet(final Money money) {
        this.money = money;
    }

    public void spend(final Money other) {
        this.money = Money.clone(money.decreased(other));
    }

    public void fill(final Money other) {
        this.money = Money.clone(money.increased(other));
    }

    public boolean hasEnoughToBuy(final Money money) {
        return this.money.isEqualsOrGreaterThan(money);
    }
}
