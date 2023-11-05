package lotto.util;

import lotto.Amount;

public class Util {
    public static boolean isNumber(String number) {
        try {
            new Amount(number);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}
