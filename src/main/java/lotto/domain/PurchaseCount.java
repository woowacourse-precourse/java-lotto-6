package lotto.domain;

public class PurchaseCount {
    private final int value;

    public PurchaseCount(int purchaseAmount) {
        validate(purchaseAmount);
        this.value = purchaseAmount/1000;
    }

    private void validate(int purchaseAmount) {
    }

    public int getValue() {
        return value;
    }
}