package lotto.domain;

public class Cashier {
    private final long purchaseAmount;

    public Cashier(String purchaseAmount) {
        long number = Integer.parseInt(purchaseAmount);
        this.purchaseAmount = number;
    }

    public long getPurchaseAmount() {
        long purchaseAmount = this.purchaseAmount;
        return purchaseAmount;
    }

}
