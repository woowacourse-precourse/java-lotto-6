package lotto.io.validator;

public class BonusNumberValidator extends InputValidator {
    @Override
    void validate(final String userInput) {
        validateInputHasSpace(userInput);
        validateInputIsNumeric(userInput);
    }
}
