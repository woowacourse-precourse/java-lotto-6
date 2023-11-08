package lotto.global.util.channel.base;

import lotto.global.exception.GlobalError;
import lotto.global.exception.GlobalException;

public abstract class DefaultValidator {
    protected abstract boolean validate(String input);

    protected void checkIsBlank(String input) {
        if (input.isBlank() || input.isEmpty()) {
            throw new GlobalException(GlobalError.BLANK_INPUT_ERROR);
        }
    }

}
