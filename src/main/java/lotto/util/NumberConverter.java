package lotto.util;

import java.math.BigInteger;
import lotto.constant.ExceptionMessage;

public class NumberConverter {
    public int convert(String number) {
        BigInteger convertedNumber = ToBigInteger(number);
        return ToInt(convertedNumber);
    }

    private BigInteger ToBigInteger(String number) {
        try {
            return new BigInteger(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER.getMessage());
        }
    }

    private int ToInt(BigInteger number) {
        if (number.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0 ||
                number.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_MESSAGE.getMessage());
        }
        return number.intValue();
    }

}
