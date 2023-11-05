package lotto;

import lotto.constant.ExceptionMessage;

public class Converter {

    public static int pay(String paymentPrice) throws IllegalArgumentException{
        try {
            return Integer.parseInt(paymentPrice);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_INTEGER);
        }
    }


}
