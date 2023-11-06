package lotto.domain;

import java.math.BigInteger;
import lotto.constant.ExceptionMessage;

public class PurchaseProcessor {
    private static final long TICKET_PRICE = 1000;
    private static final BigInteger LONG_MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
    private static final BigInteger LONG_MIN_VALUE = BigInteger.valueOf(Long.MIN_VALUE);
    private static final BigInteger ONE = BigInteger.ONE;
    private final long lottoCount;

    public PurchaseProcessor(String price) {
        long convertedCount = convertNumber(trim(price));
        this.lottoCount = convertCount(convertedCount);
    }

    private String trim(String price){
        return price.trim();
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
        checkRange(bigPrice);
        ensurePositiveValue(bigPrice);
    }

    private void checkRange(BigInteger bigPrice) {
        if (bigPrice.compareTo(LONG_MAX_VALUE) > 0 ||
                bigPrice.compareTo(LONG_MIN_VALUE) < 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT_PRICE_MESSAGE.getMessage());
        }
    }

    private void ensurePositiveValue(BigInteger bigPrice) {
        if (bigPrice.compareTo(ONE) < 0) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_INPUT_AMOUNT_INCREMENT.getMessage());
        }
    }

    private long convertCount(long price) {
        if (price % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_INPUT_AMOUNT_INCREMENT.getMessage());
        }
        return price / TICKET_PRICE;
    }

    public long getLottoCount() {
        return this.lottoCount;
    }
}
