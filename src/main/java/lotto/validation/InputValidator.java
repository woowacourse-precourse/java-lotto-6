package lotto.validation;

public class InputValidator {
    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validatePurchaseAmount(int purchaseAmount) {
        validateDividedBy1000(purchaseAmount);
        validateAmountLimit(purchaseAmount);
    }

    private static void validateAmountLimit(int purchaseAmount) {
        if (purchaseAmount > 100000) {
            throw new IllegalArgumentException();
        }

        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDividedBy1000(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
