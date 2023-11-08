package lotto.view;

import lotto.validator.InputValidator;
import lotto.validator.NumberInputValidator;

public class BonusNumberInput extends Input {

    @Override
    public void validate(String input) {
        InputValidator validator = new NumberInputValidator();
        validator.validate(input);
    }

}
