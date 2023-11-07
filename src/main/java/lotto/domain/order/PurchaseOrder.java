package lotto.domain.order;

public record PurchaseOrder(int amount) {

    private static final int LOTTO_PRICE = 1_000;
    private static final int ZERO = 0;

    public PurchaseOrder {
        validateAmount(amount);
    }

    private void validateAmount(final int amount) {
        isPositive(amount);
        isDivisibleByLottoPrice(amount);
    }

    private void isPositive(final int amount) {
        if (amount <= ZERO) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 0보다 커야 합니다.");
        }
    }

    private void isDivisibleByLottoPrice(final int amount) {
        if (amount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public int getQuantity() {
        return amount / LOTTO_PRICE;
    }
}
