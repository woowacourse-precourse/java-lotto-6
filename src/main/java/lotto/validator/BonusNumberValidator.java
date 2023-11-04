package lotto.validator;

public class BonusNumberValidator {
    public static void validateBonusNumber(final String input) {
        if (InputValidator.isEmpty(input)) {
            throw new IllegalArgumentException(InputValidator.ENTER_VALUE_MESSAGE);
        }

        if (!InputValidator.isMatchedNumberRegex(input)) {
            throw new IllegalArgumentException(InputValidator.INVALID_INPUT_CHARACTER);
        }
    }
}
