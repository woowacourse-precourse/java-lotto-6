package lotto.domain;

public class PurchaseAmount {
    private int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validate(int amount) {
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
