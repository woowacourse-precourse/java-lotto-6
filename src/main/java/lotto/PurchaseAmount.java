package lotto;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1000;
    private final int purchaseAmount;

    public static PurchaseAmount from(int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private PurchaseAmount(int purchaseAmount) {
        validateIsDividableWithLottoPrice(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validateIsDividableWithLottoPrice(int purchaseAmount) {
        if (!isDividableWithLottoPrice(purchaseAmount)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDividableWithLottoPrice(int purchaseAmount) {
        try {
            int result = purchaseAmount / LOTTO_PRICE;
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}