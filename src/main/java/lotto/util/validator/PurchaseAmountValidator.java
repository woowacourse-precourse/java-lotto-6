package lotto.util.validator;

import static lotto.util.Constant.*;
import static lotto.util.ErrorMessage.*;

public class PurchaseAmountValidator extends Validator {

    public Integer validate(String input) {
        validateNumber(input, PURCHASE_AMOUNT_PATTERN);
        int amount = Integer.parseInt(input);
        validateMinimumAmount(amount);
        validateAmountUnit(amount);
        return amount;
    }

    public static PurchaseAmountValidator createValidator() {
        return new PurchaseAmountValidator();
    }

    private void validateAmountUnit(int money) {
        if (money % AMOUNT_UNIT > REMAINDER) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT.getMessage());
        }
    }

    private void validateMinimumAmount(int money) {
        if (money < MINIMUM_AMOUNT) {
            throw new IllegalArgumentException(INVALID_MINIMUM_AMOUNT.getMessage());
        }
    }
}
