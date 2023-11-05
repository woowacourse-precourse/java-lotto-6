package lotto.io;

import lotto.constant.ErrorMessage;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern WINNING_NUMBERS_PATTERN = Pattern.compile("^([0-9]+(,[0-9]+)+)$");

    public void validateNumeric(final String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.toValue());
        }
    }

    private boolean isNotNumeric(final String input) {
        return !input.chars().allMatch(Character::isDigit);
    }

    public void validateWinningNumbers(final String input) {
        if (!WINNING_NUMBERS_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBERS.toValue());
        }
    }
}
