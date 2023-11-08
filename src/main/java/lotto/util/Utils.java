package lotto.util;

import java.text.DecimalFormat;
import lotto.exception.argument.NonNumberException;

public class Utils {
    public static final int conversionInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new NonNumberException();
        }
    }

    public static String conversionWon(int money) {
        DecimalFormat format = new DecimalFormat("###,###");

        return format.format(money);
    }
}
