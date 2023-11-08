package lotto.domain.lotto;

public class PurchaseAmount {
    public static final int LOTTO_PRICE = 1000;

    private final int amount;

    private PurchaseAmount(int purchaseAmountInput) {
        validateDivisibleBy1000(purchaseAmountInput);
        validateIsGreaterThan1000(purchaseAmountInput);
        this.amount = purchaseAmountInput;
    }

    public static PurchaseAmount of(int purchaseAmountInput) {
        return new PurchaseAmount(purchaseAmountInput);
    }

    public int getPurchaseCount() {
        return amount / LOTTO_PRICE;
    }

    private void validateDivisibleBy1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 " + LOTTO_PRICE + "원 단위이어야 합니다");
        }
    }

    private void validateIsGreaterThan1000(int purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 " + LOTTO_PRICE + "원 이상이어야 합니다");
        }
    }
}
