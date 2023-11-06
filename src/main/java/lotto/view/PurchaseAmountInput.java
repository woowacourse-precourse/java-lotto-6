package lotto.view;

import lotto.validator.PurchaseAmountInputValidator;
import lotto.validator.InputValidator;

public class PurchaseAmountInput extends Input {

    @Override
    public void validate(String input) {
        InputValidator validator = new PurchaseAmountInputValidator();
        validator.validate(input);
    }

}
