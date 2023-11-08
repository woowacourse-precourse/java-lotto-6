package lotto.view.input;

import lotto.validator.InputValidator;
import lotto.validator.NumberInputValidator;

public class BonusNumberInput extends Input {

    @Override
    protected void validate(String input) {
        InputValidator validator = new NumberInputValidator();
        validator.validate(input);
    }
}
