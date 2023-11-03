package lotto.domain.purchase;

public class PurchaseAmount {
    private static final String INVALID_RANGE = "로또 구입 금액은 1,000원부터 100,000원 사이여야 합니다.";
    private static final String INVALID_DIVIDEND = "로또 구입 금액은 1,000으로 나누어 떨어져야 합니다.";
    private static final int LOTTO_PRICE = 1_000;
    private static final int MAXIMUM = 100_000;
    private final int value;

    public PurchaseAmount(int value) {
        validateRange(value);
        validateDivisible(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < LOTTO_PRICE || value > MAXIMUM) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    private void validateDivisible(int value) {
        if (value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_DIVIDEND);
        }
    }

    public int calculatePurchaseQuantity() {
        return value / LOTTO_PRICE;
    }
}
