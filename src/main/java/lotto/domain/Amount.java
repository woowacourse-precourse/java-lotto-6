package lotto.domain;

public class Amount {

    private int amount;

    public Amount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateIsDividedByThousand(amount);
    }

    private void validateIsDividedByThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
