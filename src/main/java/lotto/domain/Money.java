package lotto.domain;

import lotto.validation.Validation;
import lotto.validation.money.MoneyDivisionCondition;
import lotto.validation.money.MoneyRangeCondition;
import lotto.validation.money.MoneyValidation;
import lotto.validation.money.NumberCondition;

import java.util.Objects;

public class Money {
    private int amount;
    private static Validation validation;
    public static final Money ZERO = Money.wons(0);
    public static final Money LOTTO_PRICE = Money.wons(1000);

    public Money(String amount){
        validation.validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    static {
        validation = new MoneyValidation(
                new NumberCondition(),
                new MoneyDivisionCondition(Money.LOTTO_PRICE),
                new MoneyRangeCondition()
        );
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
