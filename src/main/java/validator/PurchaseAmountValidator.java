package validator;

import util.constants.Constants;

public class PurchaseAmountValidator extends Validator{
    public static int isRightPurchaseAmount(String input) {
        validateBlank(input);
        int amount = validateType(input);
        return validateRange(amount, Constants.ZERO.getValue());
    }
}
