package lotto.util;

import lotto.exception.NonNumberException;

public class Utils {
    public static final int conversionInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new NonNumberException();
        }
    }
}
