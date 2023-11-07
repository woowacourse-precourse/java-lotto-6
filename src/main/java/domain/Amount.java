package domain;

import exception.NotPositiveAmountException;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new NotPositiveAmountException();
        }
    }

    public int getAmount() {
        return amount;
    }

    public Amount calculateModAmountByUnitAmount(Amount amount) {
        return new Amount(this.amount % amount.amount);
    }

    public boolean isZeroAmount() {
        return this.amount == 0;
    }

    public int calculateQuotientByUnitAmount(Amount unitAmount) {
        return this.amount / unitAmount.amount;
    }

    public double calculatePercentByUnitAmount(Amount unitAmount) {
        return (double) this.amount / unitAmount.amount * 100;
    }
}
