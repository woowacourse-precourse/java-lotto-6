package lotto.view.inputvalidator;

import static lotto.view.inputvalidator.InputValidatorRegistry.*;

public class InputValidator {
    public void validate (final String userInput) {
        validateInputHasSpace(userInput);
        validateInputContainsOnlyNumericAndComma(userInput);
        validateEmptyCheck(userInput);
    }

    public void bonusNumberInputValidate (final String userInput) {
        validateNumeric(userInput);
        validateEmptyCheck(userInput);
    }
}
