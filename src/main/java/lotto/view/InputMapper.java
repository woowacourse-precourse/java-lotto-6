package lotto.view;

import lotto.dto.PurchaseAmountRequest;
import lotto.validator.InputValidator;

public class InputMapper {

    public PurchaseAmountRequest inputToPurchaseAmountRequest(String input) {
        InputValidator.validateIsInteger(input);
        return new PurchaseAmountRequest(Integer.valueOf(input));
    }
}
