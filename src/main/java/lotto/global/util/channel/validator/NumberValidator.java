package lotto.global.util.channel.validator;

import lotto.global.exception.GlobalError;
import lotto.global.exception.GlobalException;
import lotto.global.util.channel.base.DefaultValidator;

public abstract class NumberValidator extends DefaultValidator {

    private static final String REGEX_CHECK_NUMERIC = "\\d+";
    private static final String REGEX_CHECK_ZERO_START = "^0*\\d";

    protected void checkIsNumber(String input) {
        checkIsAvailableLong(input);
        if (!input.matches(REGEX_CHECK_NUMERIC) || input.matches(REGEX_CHECK_ZERO_START)) {
            throw new GlobalException(GlobalError.NOT_INTEGER);
        }
    }

    private void checkIsAvailableLong(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new GlobalException(GlobalError.IMPOSSIBLE_PARSE_LONG_VALUE);
        }
    }
}
