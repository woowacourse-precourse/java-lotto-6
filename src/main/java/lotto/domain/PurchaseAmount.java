package lotto.domain;

public class PurchaseAmount {
    private static final int MIN_PRICE = 1000;
    private static final int ONE_LOTTO_TICKET = 1000;
    private final int purchaseAmount;

    public PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(int purchaseAmount) {
        validatePositive(purchaseAmount);
        validateMultipleOfThousand(purchaseAmount);

        return new PurchaseAmount(purchaseAmount);
    }

    public static void validatePositive(int purchaseAmount) {
        if (purchaseAmount < MIN_PRICE) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static void validateMultipleOfThousand(int purchaseAmount) {
        if (purchaseAmount % ONE_LOTTO_TICKET != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}

