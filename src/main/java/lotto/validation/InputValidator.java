package lotto.validation;

public class InputValidator {

    private InputValidator() {
    }

    public static void validatePurchaseAmount(final String purchaseAmount) {
        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!isNumeric(purchaseAmount)) {
            throw new IllegalArgumentException();
        }
        if (!isPositive(purchaseAmount)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateBonusNumber(final String bonusNumber) {
        if (bonusNumber.isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!isNumeric(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isNumeric(final String number) {
        try {
            Integer.valueOf(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isPositive(final String amount) {
        try {
            Integer numericAmount = Integer.valueOf(amount);
            return (numericAmount > 0);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
