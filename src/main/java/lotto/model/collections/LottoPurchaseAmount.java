package lotto.model.collections;

public class LottoPurchaseAmount {
    private final int amount;

    public LottoPurchaseAmount(int amount) {
        validatePositive(amount);
        validateMultipleOfThousand(amount);
        this.amount = amount;
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMultipleOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public int getAmount() {
        return amount;
    }
}
