package lotto.util;

import lotto.config.LottoConfig;
import lotto.exception.BelowMinimumPurchasePriceException;
import lotto.exception.InvalidPurchasePriceFormatException;
import lotto.exception.NonMultipleOfPriceUnitException;

public class PurchasePriceValidator {

    public static void validate(String input) {
        long purchasePrice;
        try {
            purchasePrice = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidPurchasePriceFormatException(input);
        }
        validatePurchasePriceRange(purchasePrice);
        validatePurchasePriceUnit(purchasePrice);
    }

    private static void validatePurchasePriceUnit(long purchasePrice) {
        if (purchasePrice % LottoConfig.PURCHASE_PRICE_UNIT != 0) {
            throw new NonMultipleOfPriceUnitException(purchasePrice);
        }
    }

    private static void validatePurchasePriceRange(long purchasePrice) {
        if (purchasePrice < LottoConfig.PURCHASE_PRICE_UNIT) {
            throw new BelowMinimumPurchasePriceException(purchasePrice);
        }
    }
}
