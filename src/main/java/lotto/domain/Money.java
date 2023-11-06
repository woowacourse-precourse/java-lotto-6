package lotto.domain;

import static lotto.exception.ExceptionMessage.NEGATIVE_AMOUNT;

public class Money {
    private int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money from(int amount) {
        return new Money(amount);
    }

    public void decrease(int amount) {
        int nextAmount = this.amount - amount;
        validateAmount(nextAmount);
        this.amount = nextAmount;
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw NEGATIVE_AMOUNT.getException();
        }
    }

    public boolean isEqualOrMoreThan(int amount) {
        return this.amount >= amount;
    }
}
