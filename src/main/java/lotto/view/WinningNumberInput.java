package lotto.view;

import lotto.validator.InputValidator;
import lotto.validator.WinningNumberInputValidator;

public class WinningNumberInput extends Input {

    InputValidator inputValidator;

    public WinningNumberInput(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public void validate(String input) {
        inputValidator.validate(input);
    }

}
