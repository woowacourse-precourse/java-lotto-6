package lotto.utils;

import static lotto.utils.UtilNumber.LOTTO_COST;

public class Parser {
    private static final String NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";

    public static int parseStringToInt(String stringValue) {
        try {
            int intValue = Integer.parseInt(stringValue);
            return intValue;
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    public static int parsePaymentToCoin(int payment) {
        return payment / LOTTO_COST.getNumber();
    }
}
