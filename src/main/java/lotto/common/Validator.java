package lotto.common;

public class Validator {

    public static boolean isMultipleOfNumber(int value, int unit) {
        return value % unit == 0;
    }
}
