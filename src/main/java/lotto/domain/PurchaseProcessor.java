package lotto.domain;

import java.math.BigInteger;
import lotto.constant.ExceptionMessage;

public class PurchaseProcessor {

    public PurchaseProcessor(String price) {
        convertNumber(price);
    }

    private long convertNumber(String price) {
        BigInteger bigPrice = parseToBigInteger(price);
        return convertToLong(bigPrice);
    }

    private BigInteger parseToBigInteger(String price) {
        try {
            return new BigInteger(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER.getMessage());
        }
    }

    private long convertToLong(BigInteger bigPrice) {
        validateRange(bigPrice);
        return bigPrice.longValue();
    }

    private void validateRange(BigInteger bigPrice) {
        LongRange(bigPrice);
        isPlus(bigPrice);
    }

    private void LongRange(BigInteger bigPrice) {
        if (bigPrice.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0 ||
                bigPrice.compareTo(BigInteger.valueOf(Long.MIN_VALUE)) < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_PRICE_MESSAGE.getMessage());
        }
    }

    private void isPlus(BigInteger bigPrice) {
        if (bigPrice.compareTo(BigInteger.ONE) < 0) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_INPUT_AMOUNT_INCREMENT.getMessage());
        }
    }

}