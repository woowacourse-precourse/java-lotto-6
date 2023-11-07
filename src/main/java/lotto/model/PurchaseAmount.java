package lotto.model;

public class PurchaseAmount {
    private static final int UNIT = 1000;
    private final int purchaseAmount;


    public PurchaseAmount(int purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public void validate(int purchaseAmount) {
        checkInUnit(purchaseAmount);
        checkNonNegative(purchaseAmount);
    }

    public void checkInUnit(int purchaseAmount) {
        if (purchaseAmount % UNIT > 0) {
            throw new IllegalArgumentException();
        }
    }

    public void checkNonNegative(int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException();
        }
    }
}
