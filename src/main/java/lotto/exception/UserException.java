package lotto.exception;


import static lotto.utility.Constants.ERROR_MESSAGE_1;


public class UserException {
    private UserException() {}
    public static void validateAll(String amount) {
        validatePurchaseAmountOnlyInt(amount);
        validatePurchaseAmountRange(amount);
    }

    private static void validatePurchaseAmountOnlyInt(String amount) {
        try {
            Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_1);
        }
    }

    private static void validatePurchaseAmountRange(String amount) {
        Integer purchaseAmount = Integer.parseInt(amount);
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_1);
        }

        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_1);
        }
    }


}
