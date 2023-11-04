package lotto.domain;

public class Amount {
    private final static int PRICE = 1000;
    private final int amount;

    public Amount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    private void validateAmount(int amount) {
        validateMinAmount(amount);
        validateUnit(amount);
    }

    private void validateMinAmount(int amount) {
        if (amount < PRICE) {
            throw new IllegalArgumentException(
                    ErrorMessage.MIN_AMOUNT.getValue()
            );
        }
    }

    private void validateUnit(int amount) {
        if (amount % PRICE != 0) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_UNIT.getValue()
            );
        }
    }
}

