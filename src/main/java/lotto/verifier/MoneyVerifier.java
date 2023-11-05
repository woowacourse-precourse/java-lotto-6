package lotto.verifier;

import lotto.system.Constant;
import lotto.system.ExceptionMessage;

import java.math.BigInteger;

public class MoneyVerifier implements Verifier {
    @Override
    public void check(String input) {
        checkNumeric(input);
        checkRange(input);
        checkDivisible(input);
    }

    private void checkNumeric(String input) {
        try {
            new BigInteger(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_NUMERIC);
        }
    }

    private void checkRange(String input) {
        int money = Integer.parseInt(input);
        if (money <= 0)
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_POSITIVE);
    }

    private void checkDivisible(String input) {
        int money = Integer.parseInt(input);
        if (money % Constant.MONEY_UNIT != 0)
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIVISIBLE);
    }


}
