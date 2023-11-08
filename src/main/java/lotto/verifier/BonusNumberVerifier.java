package lotto.verifier;

import lotto.system.Constant;
import lotto.system.ExceptionMessage;

import java.math.BigInteger;

public class BonusNumberVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkTypeRange(input);
        checkRange(input);

    }

    private void checkNumeric(String input) {
        try {
            new BigInteger(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_NUMERIC);
        }
    }

    private void checkTypeRange(String input) {
        try {
            Long.parseLong(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_OUT_OF_TYPE_RANGE);
        }
    }

    private void checkRange(String input) {
        long BonusNumber = Long.parseLong(input);
        if (BonusNumber < Constant.START_INCLUSIVE || BonusNumber > Constant.END_INCLUSIVE) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_EACH_OUT_OF_RANGE);
        }
    }
}
