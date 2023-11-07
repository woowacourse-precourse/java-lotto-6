package dto;

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
}
