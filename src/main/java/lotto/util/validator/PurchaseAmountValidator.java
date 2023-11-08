package lotto.util.validator;

import static lotto.util.Constant.*;
import static lotto.util.ErrorMessage.*;

public class PurchaseAmountValidator extends Validator {

    public Integer validate(String input) {
        validateNumber(input, PURCHASE_AMOUNT_PATTERN);
        validateAmountRange(input);
        int amount = Integer.parseInt(input);
        validateMinimumAmount(amount);
        validateAmountUnit(amount);
        return amount;
    }

    public static PurchaseAmountValidator createValidator() {
        return new PurchaseAmountValidator();
    }

    private static void validateAmountRange(String input) {
        if (input.length() >= INPUT_AMOUNT_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateAmountUnit(int amount) {
        if (amount % AMOUNT_UNIT > REMAINDER) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.getMessage());
        }
    }

    private void validateMinimumAmount(int amount) {
        if (amount < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(INVALID_MINIMUM_AMOUNT.getMessage());
        }
    }
}
