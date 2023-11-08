package lotto.validator;

public class PurchaseAmountValidator {
    private PurchaseAmountValidator() {
    }

    public static void validate(String amount) {
        validateInteger(amount);
        validatePositive(amount);
        validateMultipleOf1000(amount);
    }


    private static void validateInteger(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid amount format. Please enter a valid integer.");
        }
    }

    private static void validatePositive(String amount) {
        int intValue = Integer.parseInt(amount);
        if (intValue <= 0) {
            throw new IllegalArgumentException("Amount must be a positive.");
        }
    }

    private static void validateMultipleOf1000(String amount) {
        int intValue = Integer.parseInt(amount);
        if (intValue % 1000 != 0) {
            throw new IllegalArgumentException("Amount must be multiple of 1000.");
        }
    }
}
