package lotto;

public final class ValidationUtils {
    public static final int LOTTO_PRICE = 1000;
    public static final String PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION = "구입 금액은 숫자여야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_POSITIVE_EXCEPTION = "구입 금액은 양수여야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_DIVISIBLE_EXCEPTION = "구입 금액은 " + LOTTO_PRICE + "원으로 나누어 떨어져야 합니다.";

    public static void validatePurchaseAmountNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_NUMBER_EXCEPTION);
        }
    }

    public static void validatePurchaseAmountPositive(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_POSITIVE_EXCEPTION);
        }
    }

    public static void validatePurchaseAmountDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_DIVISIBLE_EXCEPTION);
        }
    }
}
