package lotto.util;

import lotto.verification.Validation;

public class Utils {

    public static long stringToLong(String string) {
        Validation.verifyStringToLong(string);
        return Long.parseLong(string);
    }

    public static long rangeInputMoney(long money){
        Validation.verifyRangeInputMoney(money);
        return money;
    }

}
