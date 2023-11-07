package domain;

import exception.ImpossibleAmountException;

public class Amount {
    private final int amount;

    public Amount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public static Amount plusAmount(Amount firstAmount, Amount secondAmount) {
        return new Amount(firstAmount.amount + secondAmount.amount);
    }

    public static Amount createZeroAmount() {
        return new Amount(0);
    }

    private void validateAmount(int amount) {
        if (amount < 0) {
            throw new ImpossibleAmountException();
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

    public Amount calculateMultiplyAmount(int value) {
        return new Amount(this.amount * value);
    }

    public double calculatePercentByUnitAmount(Amount unitAmount) {
        return (double) this.amount / unitAmount.amount * 100;
    }
}
