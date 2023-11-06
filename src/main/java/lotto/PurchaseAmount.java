package lotto;

public class PurchaseAmount {
    public static final int unit = 1000;
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        validateIsZero(amount);
        validateDivisible(amount);
    }

    private void validateIsZero(int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0원일 수 없습니다.");
        }
    }

    private void validateDivisible(int amount) {
        if (amount % unit != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 구입 금액은 %d원으로 나누어 떨어져야 합니다.", unit));
        }
    }

    public int getQuantity() {
        return amount / unit;
    }
}
