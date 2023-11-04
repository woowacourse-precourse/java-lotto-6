package lotto.domain;

public class PurchaseAmount {
    private static final int MIN_PRICE = 1000;
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(int purchaseAmount) {
        validatePositive(purchaseAmount);
        validateMultipleOfLottoPrice(purchaseAmount);
        return new PurchaseAmount(purchaseAmount);
    }

    private static void validatePositive(int purchaseAmount) {
        if (purchaseAmount < MIN_PRICE) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private static void validateMultipleOfLottoPrice(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}

