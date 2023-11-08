package lotto;

public class Util {

    public static int toInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            System.out.print(Constant.ERROR_PREFIX + Constant.INVALID_NUMBER_TYPE);
            throw new IllegalArgumentException(Constant.ERROR_PREFIX + Constant.INVALID_NUMBER_TYPE);
        }
    }
}
