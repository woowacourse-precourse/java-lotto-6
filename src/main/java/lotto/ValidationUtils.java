package lotto;

public final class ValidationUtils {
    public static final String PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION = "구입 금액은 숫자여야 합니다.";

    public static void validatePurchaseAmount(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
        }
    }
}
