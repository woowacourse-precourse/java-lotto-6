package lotto.utils;

import lotto.domain.Payment;

public class Parser {
    static final int cost = 1000;
    private static final String NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
    public static int parseStringToInt(String stringValue) {
        try {
            int intValue = Integer.parseInt(stringValue);
            return intValue;
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    public static int parseAmountToCoin(Payment purchaseAmount){
        return purchaseAmount.getAmount()/cost;
    }
}
