package lotto.domain;

public class PurchaseAmount {
    public static final int LOTTO_PRICE = 1000;
    public static final String PURCHASABILITY_EXCEPTION = "입력 값이 최소 한 장의 로또 구매 단위보다 커야 합니다.";
    public static final String LOTTO_PRICE_UNITS_EXCEPTION = "입력 값이 로또 구매 단위여야 합니다.";
    private final int purchaseAmount;

    private PurchaseAmount(final int purchaseAmount) {
        validateInputValue(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount from(final int purchaseAmount) {
        return new PurchaseAmount(purchaseAmount);
    }

    private void validateInputValue(final int purchaseAmount) {
        validatePurchasability(purchaseAmount);
        validateLottoPriceUnits(purchaseAmount);
    }

    private void validatePurchasability(final int purchaseAmount) {
        if (isNotPurchaseLotto(purchaseAmount)) {
            throw new IllegalArgumentException(PURCHASABILITY_EXCEPTION);
        }
    }

    private static boolean isNotPurchaseLotto(int purchaseAmount) {
        return purchaseAmount < LOTTO_PRICE;
    }

    private void validateLottoPriceUnits(final int purchaseAmount) {
        if (isNotLottoPriceUnits(purchaseAmount)) {
            throw new IllegalArgumentException(LOTTO_PRICE_UNITS_EXCEPTION);
        }
    }

    private static boolean isNotLottoPriceUnits(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != 0;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getPurchaseQuantity() {
        return purchaseAmount / LOTTO_PRICE;
    }
}
