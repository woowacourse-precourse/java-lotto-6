package lotto.domain;

public class Amount {
    private final int originalAmount;
    private int amount;

    public Amount(int amount) {
        this.amount = amount;
        this.originalAmount = amount;
    }

    public int getAmountDividedBy(int amount) {
        return this.amount / amount;
    }

    public void decrease(int amount) {
        this.amount -= amount;
    }

    public boolean isPurchasableBy(int amount) {
        return amount <= this.amount;
    }

    public int getOriginalAmount() {
        return originalAmount;
    }

    public int calculateLottoPurchaseSize() {
        return amount / 1000;
    }
}