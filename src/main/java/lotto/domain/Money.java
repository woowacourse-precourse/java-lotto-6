package lotto.domain;

import java.util.Objects;
import lotto.validation.Validation;
import lotto.validation.money.domain.MoneyDivisionCondition;
import lotto.validation.money.input.MoneyRangeCondition;
import lotto.validation.money.input.NumberCondition;

public class Money {
    private int amount;
    private static final Validation stringInputValidation;
    private static final Validation moneyDomainValidation;
    public static final Money ZERO = Money.wons(0);
    public static final Money LOTTO_PRICE = Money.wons(1000);

    public Money(String amountString){
        stringInputValidation.validate(amountString);
        int amount = Integer.parseInt(amountString);
        moneyDomainValidation.validate(amount);
        this.amount = amount;
    }

    public Money(int amount){
        this.amount = amount;
    }

    static {
        stringInputValidation = new Validation(
                new NumberCondition(),
                new MoneyRangeCondition()
        );

        moneyDomainValidation = new Validation(
                new MoneyDivisionCondition(Money.LOTTO_PRICE)
        );
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

    public int getAmount() {
        return amount;
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
