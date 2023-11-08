package lotto.validator;

import java.math.BigInteger;
import lotto.system.Constant;
import lotto.system.SystemMessages;

public class BonusNumberValidator implements Validator {
    private static final String BONUS_NUMBER_REGEX = "^[0-9]*$";
    private static final String BONUS_NUMBER_ERROR_MESSAGE = "보너스 번호는 숫자만 입력 가능합니다.";

    @Override
    public void check(String input) throws IllegalArgumentException {
        checkNumeric(input);
        checkOutOfTypeRange(input);
        checkOutOfRange(input);
    }

    private void checkNumeric(String input) {
        try {
            new BigInteger(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(SystemMessages.IS_NOT_NUMERIC);
        }
    }

    private void checkOutOfTypeRange(String input) {
        try {
            Long.parseLong(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(SystemMessages.NUMBER_OUT_OF_TYPE_RANGE);
        }
    }

    private void checkOutOfRange(String input) {
        long parsedLong = Long.parseLong(input);
        if (parsedLong < Constant.START_INCLUSIVE ||
                parsedLong > Constant.END_INCLUSIVE) {
            throw new IllegalArgumentException(SystemMessages.OUT_OF_RANGE);
        }
    }
}
