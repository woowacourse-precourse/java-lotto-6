package lotto.util.validators;

/**
 * 로또 구매 금액 입력을 검증하는 검사기
 */
public class PurchaseValidator {
    public static void validatePurchase(String amount) {
        validateEmpty(amount);
        Integer validatedAmount = validateInteger(amount);
        divisibilityByThousand(validatedAmount);
        validateGreaterThanZero(validatedAmount);
    }

    private static void validateEmpty(String amount) {
        if (amount.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static Integer validateInteger(String amount) {
        try {
            return Integer.valueOf(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void divisibilityByThousand(Integer amount) {
        if (amount % 1000!= 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateGreaterThanZero(Integer amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
