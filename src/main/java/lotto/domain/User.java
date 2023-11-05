package lotto.domain;

public class User {
    private long purchaseAmount;

    public void setPurchaseAmount(long purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(long purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
