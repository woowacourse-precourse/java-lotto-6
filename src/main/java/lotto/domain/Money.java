package lotto.domain;

import java.util.Objects;

public class Money {
    private int amount;
    public static final Money ZERO = Money.wons(0);

    public Money(String amount){
        this.amount = Integer.parseInt(amount);
    }

    public Money(int amount){
        this.amount = amount;
    }

    public static Money wons(int amount) {
        return new Money(amount);
    }

    public Money calculateChange(Money paid) {
        return new Money(this.amount % paid.amount);
    }

    public int calculateCount(Money price) {
        return (this.amount / price.amount);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Money)) {
            return false;
        }

        Money other = (Money) object;
        return Objects.equals(amount, other.amount);
    }
}
