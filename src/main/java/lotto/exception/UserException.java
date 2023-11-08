package lotto.exception;


import static lotto.utility.Constants.ERROR_MESSAGE_1;

public class UserException {
    private UserException() {}

    public static void validatePurchaseAmountOnlyInt(String purchaseAmount) {
        try {
            Integer tempAmount = Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_1);
        }
    }
}
