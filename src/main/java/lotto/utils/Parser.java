package lotto.utils;

import static lotto.enums.UtilNumber.LOTTO_COST;

public class Parser {

    public static int parseStringToInt(String stringValue) {
        int intValue = Integer.parseInt(stringValue);
        return intValue;
    }

    public static int parsePaymentToCoin(int payment) {
        return payment / LOTTO_COST.getNumber();
    }
}
