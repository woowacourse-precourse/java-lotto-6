package lotto.domain;

public class Money {
    private final Integer amount;

    public Money(Integer amount) {
        this.amount = amount;
    }

    public Money plus(Money amount) {
        return new Money(this.amount + amount.amount);
    }

    public Money minus(Money amount) {
        return new Money(this.amount - amount.amount);
    }

    public boolean hasNotMoney() {
        return amount <= 0;
    }
}
