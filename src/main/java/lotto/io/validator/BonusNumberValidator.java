package lotto.io.validator;

public class BonusNumberValidator extends InputValidator {
    public static void validate(final String userInput) {
        validateInputHasSpace(userInput);
        validateInputIsNumeric(userInput);
    }
}
