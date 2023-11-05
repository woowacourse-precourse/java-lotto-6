package lotto;

public class PurchaseQuantity {
    public static final int unit = 1000;
    private final int quantity;

    public PurchaseQuantity(int amount) {
        validate(amount);
        this.quantity = calculateQuantity(amount);
    }

    private void validate(int amount) {
        validateIsZero(amount);
        validateDivisible(amount);
    }

    private void validateIsZero(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivisible(int amount) {
        if (amount % unit != 0) {
            throw new IllegalArgumentException();
        }
    }

    private int calculateQuantity(int amount) {
        return amount / unit;
    }

    public int getQuantity() {
        return quantity;
    }
}
