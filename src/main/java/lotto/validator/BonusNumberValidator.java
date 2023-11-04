package lotto.validator;

public class BonusNumberValidator {
    public static void inputValidate(final String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(InputValidator.ENTER_VALUE_MESSAGE);
        }

        if (!InputValidator.isMatchedNumberRegex(input)) {
            throw new IllegalArgumentException(InputValidator.INVALID_INPUT_CHARACTER);
        }
    }
}
