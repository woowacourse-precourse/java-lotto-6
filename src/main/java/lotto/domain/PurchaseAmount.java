package lotto.domain;

public class PurchaseAmount {
    private static final int MIN_PRICE = 1000;
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    private PurchaseAmount(int purchaseAmount) {
        validatePositive(purchaseAmount);
        validateMultipleOfLottoPrice(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(String readPurchaseAmount) {
        validateNumeric(readPurchaseAmount);
        int purchaseAmount = Integer.parseInt(readPurchaseAmount);
        return new PurchaseAmount(purchaseAmount);
    }

    private static void validateNumeric(String purchaseAmount) {
        if (!purchaseAmount.chars()
                .allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validatePositive(int purchaseAmount) {
        if (purchaseAmount < MIN_PRICE) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateMultipleOfLottoPrice(int purchaseAmount) {
        if (purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}

