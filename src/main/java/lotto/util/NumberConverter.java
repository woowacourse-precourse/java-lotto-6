package lotto.util;

import java.math.BigInteger;
import lotto.constant.ExceptionMessage;

public class NumberConverter {
    public int convert(String number) {
        BigInteger convertedNumber = toBigNumber(number);
        return toNumber(convertedNumber);
    }

    private BigInteger toBigNumber(String number) {
        try {
            return new BigInteger(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER.getMessage());
        }
    }

    private int toNumber(BigInteger number) {
        if (number.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ||
                number.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_MESSAGE.getMessage());
        }
        return number.intValue();
    }

}
