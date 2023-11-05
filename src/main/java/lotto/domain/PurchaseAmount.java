package lotto.domain;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(String amount) {
        this.amount = toInt(amount);
    }

    public int getAmount() {
        return this.amount;
    }

    private int toInt(String amount) {
        return Integer.parseInt(amount);
    }
}
