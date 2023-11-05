package lotto.view.input;

import lotto.validator.AmountInputValidator;
import lotto.validator.InputValidator;

public class AmountInput extends Input {

    @Override
    protected void validate(String input) {
        InputValidator validator = new AmountInputValidator();
        validator.validate(input);
    }
}
