package lotto.domain;

import java.math.BigInteger;
import lotto.constant.ExceptionMessage;

public class PurchaseProcessor {

    public PurchaseProcessor(String price) {
        convertNumber(price);
    }

    private void convertNumber(String price) {
        BigInteger bigPrice = parseToBigInteger(price);
    }

    private BigInteger parseToBigInteger(String price) {
        try {
            return new BigInteger(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER.getMessage());
        }
    }

}
