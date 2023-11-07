package lotto.view.inputvalidator;

import static lotto.view.inputvalidator.InputValidatorRegistry.*;

public class InputValidator {
    public void lottoWinningNumberValidate(final String userInput) {
        validateInputHasSpace(userInput);
        validateInputContainsOnlyNumericAndComma(userInput);
        validateEmptyCheck(userInput);
    }

    public void priceInputValidate(final String userInput) {
        validateInputHasSpace(userInput);
        validateNumeric(userInput);
        validateEmptyCheck(userInput);
        validate1000s(userInput);
    }

    public void bonusNumberInputValidate (final String userInput) {
        validateNumeric(userInput);
        validateEmptyCheck(userInput);
    }
}
