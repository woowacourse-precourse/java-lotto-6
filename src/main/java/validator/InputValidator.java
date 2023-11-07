package validator;

import lotto.Unit;
import message.ErrorMessage;

public class InputValidator {

    public static void validatePurchaseAmountInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE.getMessage());
        }
        int amount = Integer.parseInt(input);
        if (amount % Unit.PURCHASE_AMOUNT_UNIT.getUnit() != Unit.ZERO.getUnit()) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE.getMessage());
        }
    }
}
