package lotto.global.util.channel.validator;

import lotto.global.exception.GlobalError;
import lotto.global.exception.GlobalException;
import lotto.global.util.channel.base.DefaultValidator;

/**
 * @see lotto.global.util.channel.base.DefaultValidator
 */
public abstract class NumberValidator extends DefaultValidator {

    protected void checkIsNumber(String input) {
        checkIsAvailableLong(input);
        checkIsAvailableInteger(input);
    }

    /** 지나치게 긴 숫자를 입력했을 경우를 대비하여 Long 형변환을 시도하여 검사합니다. */
    private void checkIsAvailableLong(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new GlobalException(GlobalError.NOT_AVAILABLE_INTEGER);
        }
    }

    /** 올바른 형식의 정수를 입력했는지 검사합니다. */
    private void checkIsAvailableInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new GlobalException(GlobalError.NOT_AVAILABLE_INTEGER);
        }
    }
}
