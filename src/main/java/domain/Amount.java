package domain;

import exception.ImpossibleAmountException;

public class Amount {
    private final long amount;

    public Amount(long amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public static Amount plusAmount(Amount firstAmount, Amount secondAmount) {
        return new Amount(firstAmount.amount + secondAmount.amount);
    }

    public static Amount createZeroAmount() {
        return new Amount(0);
    }

    private void validateAmount(long amount) {
        if (amount < 0) {
            throw new ImpossibleAmountException();
        }
    }

    public long getAmount() {
        return amount;
    }

    public Amount calculateModAmountByUnitAmount(Amount amount) {
        return new Amount(this.amount % amount.amount);
    }

    public boolean isZeroAmount() {
        return this.amount == 0;
    }

    public long calculateQuotientByUnitAmount(Amount unitAmount) {
        return this.amount / unitAmount.amount;
    }

    public Amount calculateMultiplyAmount(int value) {
        return new Amount(this.amount * value);
    }

    public double calculatePercentByUnitAmount(Amount unitAmount) {
        return (double) this.amount / unitAmount.amount * 100;
    }

    public boolean isOverLimitAmount(Amount limitAmount) {
        return limitAmount.amount < this.amount;
    }
}
