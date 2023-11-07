package lotto.io.input;

import lotto.constant.message.ExceptionMessage;
import lotto.constant.LottoConstant;
import lotto.constant.RegexPattern;

public class InputValidator {


    private static boolean isContainDelimiter(final String input) {
        return !input.contains(LottoConstant.DELIMITER);
    }

    public void validateNumeric(final String input) {
        if (isNumeric(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMERIC_INPUT.toMessage());
        }
    }

    private boolean isNumeric(final String input) {
        return RegexPattern.isNumberic(input);
    }

    public void validateNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_NULL.toMessage());
        }
    }

    public void validateHasDelimiter(final String input) {
        if (isContainDelimiter(input)) {
            throw new IllegalArgumentException(ExceptionMessage.DO_NOT_HAVE_DELIMITER.toMessage());
        }
    }
}
