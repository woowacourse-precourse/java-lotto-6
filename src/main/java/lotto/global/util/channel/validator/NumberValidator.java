package lotto.global.util.channel.validator;

import lotto.global.exception.GlobalError;
import lotto.global.exception.GlobalException;
import lotto.global.util.channel.base.DefaultValidator;

public abstract class NumberValidator extends DefaultValidator {

    protected void checkIsNumber(String input) {
        checkIsAvailableLong(input);
        checkIsAvailableInteger(input);
    }

    private void checkIsAvailableLong(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new GlobalException(GlobalError.NOT_AVAILABLE_INTEGER);
        }
    }
    private void checkIsAvailableInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new GlobalException(GlobalError.NOT_AVAILABLE_INTEGER);
        }
    }
}
