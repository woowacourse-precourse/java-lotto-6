package lotto.domain;

import static lotto.domain.Lotto.PRICE;
import static lotto.error.ErrorMessage.INVALID_PURCHASE_AMOUNT_FORMAT;
import static lotto.error.ErrorMessage.NEGATIVE_PURCHASE_AMOUNT;
import static lotto.error.ErrorMessage.NOT_DIVIDED_PURCHASE_AMOUNT;

public final class PurchaseAmount {
    private final Integer purchaseAmount;

    private PurchaseAmount(Integer purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static PurchaseAmount of(String input) {
        return new PurchaseAmount(validatePurchaseAmount(input));
    }

    private static Integer validatePurchaseAmount(String input) {
        Integer purchaseAmount = validateFormatAndConvert(input, INVALID_PURCHASE_AMOUNT_FORMAT);
        validatePositiveNumber(purchaseAmount, NEGATIVE_PURCHASE_AMOUNT);
        validateDivided(purchaseAmount, NOT_DIVIDED_PURCHASE_AMOUNT);
        return purchaseAmount;
    }

    private static Integer validateFormatAndConvert(String input, String error) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(error);
        }
    }

    private static void validatePositiveNumber(Integer number, String error) {
        if (number <= 0) {
            throw new IllegalArgumentException(error);
        }
    }

    private static void validateDivided(Integer number, String error) {
        if (number % PRICE != 0) {
            throw new IllegalArgumentException(error);
        }
    }

    public int getCount() {
        return purchaseAmount / PRICE;
    }

    public Double rateOfReturn(int revenue) {
        return ((double) revenue / purchaseAmount) * 100;
    }
}
