package lotto.io;

import java.util.regex.Pattern;
import lotto.constant.ExceptionMessage;
import lotto.constant.LottoConstant;

public class InputValidator {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

    private static boolean isContainDelimiter(String input) {
        return !input.contains(LottoConstant.DELIMITER);
    }

    public void validateNumeric(String input) {
        if (isNumeric(input)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMERIC_INPUT.toMessage());
        }
    }

    private boolean isNumeric(String input) {
        return !NUMERIC_PATTERN.matcher(input).matches();
    }

    public void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_NULL.toMessage());
        }
    }

    public void validateHasDelimiter(String input) {
        if (isContainDelimiter(input)) {
            throw new IllegalArgumentException(ExceptionMessage.DO_NOT_HAVE_DELIMITER.toMessage());
        }
    }
}
