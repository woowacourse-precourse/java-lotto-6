package lotto.domain;

import lotto.domain.exception.lottoException.LottoPriceUnitsException;
import lotto.domain.exception.PurchaseNotAvailableException;

public class PurchaseAmount {
    public static final int LOTTO_PRICE = 1000;
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
            throw new PurchaseNotAvailableException();
        }
    }

    private static boolean isNotPurchaseLotto(int purchaseAmount) {
        return purchaseAmount < LOTTO_PRICE;
    }

    private void validateLottoPriceUnits(final int purchaseAmount) {
        if (isNotLottoPriceUnits(purchaseAmount)) {
            throw new LottoPriceUnitsException();
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
