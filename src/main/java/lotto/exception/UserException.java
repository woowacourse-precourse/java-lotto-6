package lotto.exception;


import static lotto.utility.Constants.ERROR_MESSAGE_2;
import static lotto.utility.Constants.ONLYINT;

public class UserException {
    private UserException() {}

    public static void validatePurchaseAmountOnlyInt(String purchaseAmount) {
        try {
            Integer.parseInt(purchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE_2);
            throw new IllegalStateException(ERROR_MESSAGE_2);
        }
    }
}
