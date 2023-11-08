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
    }

    private static void validatePositive(String amount) {
    }

    private static void validateMultipleOf1000(String amount) {
    }
}
